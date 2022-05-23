package acme.features.inventor.toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.SpamCheck;
import acme.entities.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorToolKitCreateService implements AbstractCreateService<Inventor, ToolKit>{
	
	@Autowired
	protected InventorToolKitRepository repository;
	
	
	@Override
	public boolean authorise(final Request<ToolKit> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void bind(final Request<ToolKit> request, final ToolKit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "code", "title", "description", "assemblyNotes", "optionalLink", "published");
	}

	@Override
	public void unbind(final Request<ToolKit> request, final ToolKit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		model.setAttribute("readOnly", false);
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "optionalLink", "published");
	}

	@Override
	public ToolKit instantiate(final Request<ToolKit> request) {
		assert request != null;
		ToolKit result;
		
		Inventor inventor;
		inventor = this.repository.findInventorById(request.getPrincipal().getActiveRoleId());
		
		result = new ToolKit();
		result.setPublished(false);
		result.setInventor(inventor);
		
		return result;
	}

	@Override
	public void validate(final Request<ToolKit> request, final ToolKit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		if(!errors.hasErrors("code")) {
			ToolKit toolKit;
			toolKit = this.repository.findToolKitByCode(entity.getCode());
			errors.state(request, toolKit == null || toolKit.getCode() == entity.getCode(), "code", "inventor.tool-kit.form.error.duplicated");
			
			boolean descriptionWithinThreshold, titleWithinThreshold, assemblyNotesWithinThreshold;
			
			descriptionWithinThreshold = SpamCheck.isWithinSpamThreshold(entity.getDescription());
			titleWithinThreshold = SpamCheck.isWithinSpamThreshold(entity.getTitle());
			assemblyNotesWithinThreshold = SpamCheck.isWithinSpamThreshold(entity.getAssemblyNotes());
			
			errors.state(request, !descriptionWithinThreshold, "description", "inventor.tool-kit.form.error.spam");
			errors.state(request, !titleWithinThreshold, "name", "inventor.tool-kit.form.error.spam");
			errors.state(request, !assemblyNotesWithinThreshold, "assemblyNotes", "inventor.tool-kit.form.error.spam");
		}
	}

	@Override
	public void create(final Request<ToolKit> request, final ToolKit entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
		
	}

}
