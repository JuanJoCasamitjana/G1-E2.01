package acme.features.inventor.toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorToolKitPublishService implements AbstractUpdateService<Inventor, ToolKit> {
	
	@Autowired
	protected InventorToolKitRepository repository;
	
	@Override
	public boolean authorise(final Request<ToolKit> request) {
		assert request != null;
		
		boolean result;
		ToolKit toolKit;
		Boolean published;
		
		toolKit = this.repository.findOneToolkitById(request.getModel().getInteger("id"));
		published = toolKit.isPublished();
		result = request.getPrincipal().getActiveRoleId() == toolKit.getInventor().getId();
		
		
		return result && !published;
	}

	@Override
	public void bind(final Request<ToolKit> request, final ToolKit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		entity.setPublished(true);
		
		request.bind(entity, errors, "code", "title", "description", "assemblyNotes", "optionalLink");
		
	}

	@Override
	public void unbind(final Request<ToolKit> request, final ToolKit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "optionalLink", "published");
	}

	@Override
	public ToolKit findOne(final Request<ToolKit> request) {
		assert request != null;
		ToolKit result;
		result = this.repository.findOneToolkitById(request.getModel().getInteger("id"));
		return result;
	}

	@Override
	public void validate(final Request<ToolKit> request, final ToolKit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		if(!errors.hasErrors("code")) {
			Integer itemsInToolKit;
			
			itemsInToolKit = this.repository.countItemsInToolKitByCode(entity.getCode());
			errors.state(request, itemsInToolKit>0, "published", "inventor.tool-kit.publish.form.error.no-items");
		}
	}

	@Override
	public void update(final Request<ToolKit> request, final ToolKit entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
