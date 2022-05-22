package acme.features.patron.patronage;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.entities.Status;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;
import acme.roles.Patron;

@Service
public class PatronPatronageCreateService implements AbstractCreateService<Patron, Patronage>{
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected PatronPatronageRepository repository;
	
	// AbstractCreateService<Patron, Patronage> interface -------------------------
	
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "status", "code", "legalStuff", "budget", "startDate", "finishDate", "published", "moreInfo");
		entity.setInventor(this.repository.findInventorByInventorUsername(request.getModel().getAttribute("inventor").toString()));
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		Date creationDate;
		creationDate = new Date(System.currentTimeMillis()-1);
		entity.setCreationDate(creationDate);
		entity.setStatus(Status.PROPOSED);
		entity.setPublished(false);
		
		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "creationDate", "startDate", "finishDate", "published", "moreInfo");
		model.setAttribute("inventors", this.repository.findAllInventors());
	}

	@Override
	public Patronage instantiate(final Request<Patronage> request) {
		Patronage result;
		Date creationDate;
		Date startDate;
		Date finishDate;
		
		result = new Patronage();
		creationDate = new Date(System.currentTimeMillis()-1);
		startDate = DateUtils.addMonths(creationDate, 1);
		finishDate = DateUtils.addMonths(startDate, 1);
		
		result.setStatus(Status.PROPOSED);
		result.setCreationDate(creationDate);
		result.setStartDate(startDate);
		result.setFinishDate(finishDate);
		
		final Integer patronId = request.getPrincipal().getActiveRoleId();
		result.setPatron(this.repository.findPatronByPatronId(patronId));
		
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
	public void create(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
	}

}
