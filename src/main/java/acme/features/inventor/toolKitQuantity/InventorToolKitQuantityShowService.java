package acme.features.inventor.toolKitQuantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Quantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolKitQuantityShowService implements AbstractShowService<Inventor, Quantity>{
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected InventorToolKitQuantityRepository repository;
		
	// AbstractListService<Inventor, ToolKit> interface --------------
	
	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public Quantity findOne(final Request<Quantity> request) {
		assert request != null;
		
		Quantity result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneQuantityById(id);
		
		return result;
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		boolean sameInventor;
		Quantity q;
		
		q = this.repository.findOneQuantityById(request.getModel().getInteger("id"));
		sameInventor = request.getPrincipal().getActiveRoleId() == q.getToolKit().getInventor().getId();
		
		model.setAttribute("sameInventor", sameInventor);
		model.setAttribute("itemCode", q.getItem().getCode());
		
		
		request.unbind(entity, model, "amount");
	}
	
}
