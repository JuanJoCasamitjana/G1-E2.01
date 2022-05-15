
package acme.features.inventor.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorItemPublishService implements AbstractUpdateService<Inventor, Item> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorItemRepository repository;

	// AbstractUpdateService<Inventor, Item> interface -------------------------
	
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

		request.unbind(entity, model, "type", "name", "code", "technology", "description", "retailPrice", "optionalLink","published");
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
		if(!errors.hasErrors("code")) {
			Item item;
			item = this.repository.findItemByCode(entity.getCode());
			errors.state(request, item == null || item.getCode().equals(entity.getCode()), "code", "inventor.item.form.error.duplicated");
		}
	}

	@Override
	public void update(final Request<Item> request, final Item entity) {
		assert request != null;
		assert entity != null;

		entity.setPublished(true);
		this.repository.save(entity);
	}

}
