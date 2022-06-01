package acme.features.inventor.toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			errors.state(request, toolKit == null || toolKit.getCode().equals(entity.getCode()), "code", "inventor.tool-kit.form.error.duplicated");
		}
	}

	@Override
	public void create(final Request<ToolKit> request, final ToolKit entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
		
	}

}
