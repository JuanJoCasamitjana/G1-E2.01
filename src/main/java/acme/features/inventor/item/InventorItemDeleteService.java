package acme.features.inventor.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorItemDeleteService implements AbstractDeleteService<Inventor, Item>  {

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected InventorItemRepository repository;
	
	// AbstractDeleteService<Inventor, Item> interface -------------------------

	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		
		boolean result;
		Item item;
		Boolean published;
		
		item = this.repository.findOneItemByItemId(request.getModel().getInteger("id"));
		published = item.isPublished();
		result = request.getPrincipal().getActiveRoleId() == item.getInventor().getId();
		
		return result && !published;
	}

	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "type", "name", "code", "technology", "description", "retailPrice", "published", "optionalLink");
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "type", "name", "code", "technology", "description", "retailPrice", "published", "optionalLink");
	}

	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;
		Item result;
		result = this.repository.findOneItemByItemId(request.getModel().getInteger("id"));
		return result;
	}

	@Override
	public void validate(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<Item> request, final Item entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.delete(entity);
	}

	
}
