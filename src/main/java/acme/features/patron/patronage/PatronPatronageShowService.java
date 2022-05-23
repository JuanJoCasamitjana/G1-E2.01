package acme.features.patron.patronage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronPatronageShowService implements AbstractShowService<Patron, Patronage> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronPatronageRepository repository;

	// AbstractShowService<Patron, Patronage> interface --------------


	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		boolean result = false;
		
		final int patronId = request.getPrincipal().getActiveRoleId();
		final int id = request.getModel().getInteger("id");
		final Patronage patronage = this.repository.findOnePatronageById(id);
		if (patronId == patronage.getPatron().getId()) {
			result = true;
		}
		return result;
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
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		model.setAttribute("inventorId", entity.getInventor().getUserAccount().getId());
		model.setAttribute("inventors", this.repository.findAllInventors());
		
		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "creationDate", "startDate", "finishDate", "published", "moreInfo");
	}
	
}
