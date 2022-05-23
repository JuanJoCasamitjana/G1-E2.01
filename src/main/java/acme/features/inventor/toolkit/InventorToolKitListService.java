package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorToolKitListService implements AbstractListService<Inventor, ToolKit>{

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected InventorToolKitRepository repository;
	
	// AbstractListService<Inventor, ToolKit> interface --------------
	
	@Override
	public boolean authorise(final Request<ToolKit> request) {
		assert request != null;
		return true;
	}

	@Override
	public Collection<ToolKit> findMany(final Request<ToolKit> request) {
		assert request != null;
		
		Collection<ToolKit> result;
		
		final int inventorId = request.getPrincipal().getActiveRoleId();
		result = this.repository.findOwnToolkits(inventorId);
		
		return result;
	}

	@Override
	public void unbind(final Request<ToolKit> request, final ToolKit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code", "title", "published");
	}
	
}
