package acme.features.inventor.toolKitQuantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.Quantity;
import acme.entities.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorToolKitQuantityCreateService implements AbstractCreateService<Inventor, Quantity>{
	
	@Autowired
	protected InventorToolKitQuantityRepository repository;
	
	
	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		
		boolean sameInventor;
		ToolKit tk;
		int inventorId, toolKitId;
		Boolean notPublished;
		
		
		toolKitId = request.getModel().getInteger("toolKitId");
		
		tk = this.repository.findToolKitById(toolKitId);
		
		notPublished = !tk.isPublished();
		
		inventorId = request.getPrincipal().getActiveRoleId();
		
		sameInventor = inventorId == tk.getInventor().getId();
		
		
		return notPublished && sameInventor;
	}

	@Override
	public void bind(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		Item it;
		String itemCode;
		
		itemCode = request.getModel().getString("itemCode");
		it = this.repository.findItemByCode(itemCode);
		
		entity.setItem(it);
		
		request.bind(entity, errors, "amount");
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		int tkId;
		
		tkId = request.getModel().getInteger("toolKitId");
		
		
		model.setAttribute("toolKitId", tkId);
		request.unbind(entity, model, "amount");
	}

	@Override
	public Quantity instantiate(final Request<Quantity> request) {
		assert request != null;
		Quantity result;
		
		ToolKit tk;
		tk = this.repository.findToolKitById(request.getModel().getInteger("toolKitId"));
		
		result = new Quantity();
		result.setToolKit(tk);
		
		return result;
	}

	@Override
	public void validate(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(!errors.hasErrors("itemCode")) {
			ToolKit tk;
			tk = this.repository.findToolKitById(request.getModel().getInteger("toolKitId"));
			
			errors.state(request, !tk.isPublished(), "amount", "inventor.quantity.form.error.published.tk");
			
			String itC;
			Item it;
			
			itC = request.getModel().getString("itemCode");
			it = this.repository.findItemByCode(itC);
			
			errors.state(request, it.isPublished(), "itemCode", "inventor.quantity.form.error.not-published.item");
		}
		
	}

	@Override
	public void create(final Request<Quantity> request, final Quantity entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
	}

}
