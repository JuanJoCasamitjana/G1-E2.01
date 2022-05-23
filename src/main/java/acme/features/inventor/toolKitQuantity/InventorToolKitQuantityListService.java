/*
 * AdministratorUserAccountListService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.inventor.toolKitQuantity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.Quantity;
import acme.entities.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.helpers.CollectionHelper;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorToolKitQuantityListService implements AbstractListService<Inventor, Quantity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorToolKitQuantityRepository repository;

	// AbstractListService<Administrator, UserAccount> interface --------------


	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		boolean sameInventor;
		ToolKit tk;
		
		tk = this.repository.findToolKitById(request.getModel().getInteger("toolKitId"));
		
		sameInventor = request.getPrincipal().getActiveRoleId() == tk.getInventor().getId();
		
		return sameInventor;
	}
	
	@Override
	public Collection<Quantity> findMany(final Request<Quantity> request) {
		assert request != null;

		Collection<Quantity> result;
		int id;
		
		id = request.getModel().getInteger("toolKitId");
		result = this.repository.findAllItemsFromToolKitByIdAllPublished(id);
		
		return result;
	}
	
	@Override
	public void unbind(final Request<Quantity> request, final Collection<Quantity> entities, final Model model) {
		assert request != null;
		assert !CollectionHelper.someNull(entities);
		assert model != null;
		
		int toolKitId;
		
		toolKitId = request.getModel().getInteger("toolKitId");
		model.setAttribute("toolKitId", toolKitId);
		
	}
	
	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		Money itemPrice;
		String itemName, itemType, itemCode, itemTechnology;
		
		Item it;
		it = entity.getItem();
		
		itemName = it.getName();
		itemCode = it.getCode();
		itemType = it.getType().toString();
		itemTechnology = it.getTechnology();
		itemPrice = it.getRetailPrice();
		
		model.setAttribute("name", itemName);
		model.setAttribute("code", itemCode);
		model.setAttribute("type", itemType);
		model.setAttribute("technology", itemTechnology);
		model.setAttribute("price", itemPrice);
		
		request.unbind(entity, model, "amount");
	}

}
