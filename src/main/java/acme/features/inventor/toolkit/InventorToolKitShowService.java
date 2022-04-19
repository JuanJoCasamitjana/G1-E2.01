package acme.features.inventor.toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolKitShowService implements AbstractShowService<Inventor, ToolKit>{
	
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
	public ToolKit findOne(final Request<ToolKit> request) {
		assert request != null;
		
		ToolKit result;
		final int id = request.getModel().getInteger("id");
		result = this.repository.findOneToolkitById(id);
		return result;
	}

	@Override
	public void unbind(final Request<ToolKit> request, final ToolKit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "optionalLink");
	}
	
}
