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

package acme.features.any.toolKitQuantity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.Quantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyToolKitQuantityListService implements AbstractListService<Any, Quantity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyToolKitQuantityRepository repository;

	// AbstractListService<Administrator, UserAccount> interface --------------


	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;

		return true;
	}
	
	@Override
	public Collection<Quantity> findMany(final Request<Quantity> request) {
		assert request != null;

		Collection<Quantity> result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findAllItemsFromToolKitById(id);
		
		return result;
	}
	
	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		Money itemPrice;
		String itemName, itemType, itemCode, itemTechnology;
		
		final Item it = entity.getItem();
		
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
