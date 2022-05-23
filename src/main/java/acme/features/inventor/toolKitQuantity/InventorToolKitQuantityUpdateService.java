package acme.features.inventor.toolKitQuantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.Quantity;
import acme.entities.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorToolKitQuantityUpdateService implements AbstractUpdateService<Inventor, Quantity>{

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected InventorToolKitQuantityRepository repository;
		
	// AbstractUpdateService<Inventor, Item> interface -------------------------
	
	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		
		boolean result;
		Quantity q;
		Boolean published;
		
		q = this.repository.findOneQuantityById(request.getModel().getInteger("id"));
		published = q.getToolKit().isPublished();
		result = request.getPrincipal().getActiveRoleId() == q.getToolKit().getInventor().getId();
		
		return result && !published;
	}

	@Override
	public void bind(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "amount");
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "amount");
		
		Item it;
		it = this.repository.findOneQuantityById(request.getModel().getInteger("id")).getItem();
		
		model.setAttribute("itemCode", it.getCode());
	}

	@Override
	public Quantity findOne(final Request<Quantity> request) {
		assert request != null;
		Quantity result;
		
		result = this.repository.findOneQuantityById(request.getModel().getInteger("id"));
		return result;
	}

	@Override
	public void validate(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		if(!errors.hasErrors("amount")) {
			ToolKit tk;
			tk = this.repository.findOneQuantityById(request.getModel().getInteger("id")).getToolKit();
			
			errors.state(request, !tk.isPublished(), "amount", "inventor.quantity.form.error.published");
		}
	}

	@Override
	public void update(final Request<Quantity> request, final Quantity entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
