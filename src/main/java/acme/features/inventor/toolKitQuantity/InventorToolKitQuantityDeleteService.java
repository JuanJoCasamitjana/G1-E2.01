package acme.features.inventor.toolKitQuantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.Quantity;
import acme.entities.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorToolKitQuantityDeleteService implements AbstractDeleteService<Inventor, Quantity> {
	
	@Autowired
	protected InventorToolKitQuantityRepository repository;
	
	
	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		
		final boolean sameInventor;
		ToolKit toolKit;
		Boolean notPublished;
		
		toolKit = this.repository.findOneQuantityById(request.getModel().getInteger("id")).getToolKit();
		notPublished = !toolKit.isPublished();
		sameInventor = request.getPrincipal().getActiveRoleId() == toolKit.getInventor().getId();
		
		
		return sameInventor && notPublished;
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
		
		Item it;
		it = this.repository.findOneQuantityById(request.getModel().getInteger("id")).getItem();
		
		request.unbind(entity, model, "amount");
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
	}

	@Override
	public void delete(final Request<Quantity> request, final Quantity entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.delete(entity);
	}

}
