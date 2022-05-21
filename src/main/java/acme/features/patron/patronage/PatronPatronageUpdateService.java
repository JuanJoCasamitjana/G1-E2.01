package acme.features.patron.patronage;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.entities.Status;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.HttpMethod;
import acme.framework.controllers.Request;
import acme.framework.controllers.Response;
import acme.framework.datatypes.Money;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Patron;

@Service
public class PatronPatronageUpdateService implements AbstractUpdateService<Patron, Patronage>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronPatronageRepository repository;

	// AbstractUpdateService<Patron, Patronage> interface --------------
	
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		boolean result = false;
		
		final int patronId = request.getPrincipal().getActiveRoleId();
		final int id = request.getModel().getInteger("id");
		final Patronage patronage = this.repository.findOnePatronageById(id);
		if (patronId == patronage.getPatron().getId() && !patronage.isPublished()) {
			result = true;
		}
		return result;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "status", "code", "legalStuff", "budget", "creationDate", "startDate", "finishDate", "published", "moreInfo");
		entity.setInventor(this.repository.findInventorByInventorUsername(request.getModel().getAttribute("inventor").toString()));
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "creationDate", "startDate", "finishDate", "published", "moreInfo");
		model.setAttribute("inventors", this.repository.findAllInventors());
	}

	@Override
	public Patronage findOne(final Request<Patronage> request) {
		assert request != null;

		Patronage result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOnePatronageById(id);

		return result;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if (!errors.hasErrors("code")) {
			Patronage pWithSameCode;
			pWithSameCode = this.repository.findOnePatronageByCode(entity.getCode());
			final Boolean sameCodeExists = pWithSameCode == null || pWithSameCode.getId() == entity.getId();
			errors.state(request, sameCodeExists, "code", "patron.patronage.form.error.code");
		}
		if (!errors.hasErrors("budget")) {
			final Money budget = entity.getBudget();
			final Boolean isBudgetOverZero = budget.getAmount() > 0.;
			final String[] splits = this.repository.findAcceptedCurrencies().split(",");
			Boolean isCurrencyAccepted;
			isCurrencyAccepted = false;
			for (int i = 0; i < splits.length; i++) {
				if (splits[i].equals(budget.getCurrency())) {
					isCurrencyAccepted = true;
				}
			}
			errors.state(request, isBudgetOverZero, "budget", "patron.patronage.form.error.budget.amount");
			errors.state(request, isCurrencyAccepted, "budget", "patron.patronage.form.error.budget.currency");
		}
		if (!errors.hasErrors("startDate")) {
			Date minimumStartDate;
			minimumStartDate = DateUtils.addMonths(entity.getCreationDate(), 1);
			final Boolean isStartDateAfterMinimum = entity.getStartDate().after(DateUtils.addMinutes(minimumStartDate, -1));
			errors.state(request, isStartDateAfterMinimum, "startDate", "patron.patronage.form.error.startDate");
		}
		if (!errors.hasErrors("finishDate")) {
			Date minimumFinishDate;
			minimumFinishDate = DateUtils.addMonths(entity.getStartDate(), 1);
			final Boolean isFinishDateAfterMinimum = entity.getFinishDate().after(DateUtils.addMinutes(minimumFinishDate, -1));
			errors.state(request, isFinishDateAfterMinimum, "finishDate", "patron.patronage.form.error.finishDate");
		}
		
	}

	@Override
	public void update(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;
		
		entity.setStatus(Status.PROPOSED);
		this.repository.save(entity);
	}
	
	@Override
	public void onSuccess(final Request<Patronage> request, final Response<Patronage> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}
	
}
