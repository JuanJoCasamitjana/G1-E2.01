package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.ItemType;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;
@Service
public class InventorComponentListService implements AbstractListService<Inventor,Item> {

	@Autowired
	protected InventorItemRepository repository;
	
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Item> findMany(final Request<Item> request) {
		int id;
		Collection<Item> result;
		
		id = request.getPrincipal().getActiveRoleId();
		final ItemType type = ItemType.COMPONENT;
		result = this.repository.findItemsByInventorIdAndItemType(id,type);
		return result;
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "type","name","code","technology","description","retailPrice","optionalLink","published");
	}

}
