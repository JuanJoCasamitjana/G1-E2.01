/*
 * AdministratorUserAccountShowService.java
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.Quantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyToolKitQuantityShowService implements AbstractShowService<Any, Quantity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyToolKitQuantityRepository repository;

	// AbstractShowService<Administrator, UserAccount> interface --------------


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

		int id;

		id = request.getModel().getInteger("id");
		model.setAttribute("id", id);
		
		Money itemPrice;
		String itemName, itemType, itemCode, itemTechnology, itemDescription, itemLink;
		final Item it = entity.getItem();
		
		itemName = it.getName();
		itemCode = it.getCode();
		itemType = it.getType().toString();
		itemTechnology = it.getTechnology();
		itemPrice = it.getRetailPrice();
		itemDescription = it.getDescription();
		itemLink = it.getOptionalLink();
		
		
		model.setAttribute("description", itemDescription);
		model.setAttribute("link", itemLink);
		model.setAttribute("name", itemName);
		model.setAttribute("code", itemCode);
		model.setAttribute("type", itemType);
		model.setAttribute("technology", itemTechnology);
		model.setAttribute("price", itemPrice);
		
		
		
		request.unbind(entity, model, "item", "toolKit", "amount");
	}
	
}
