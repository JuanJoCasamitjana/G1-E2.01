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

package acme.features.any.toolKit;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.ItemType;
import acme.entities.Quantity;
import acme.entities.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyToolKitListService implements AbstractListService<Any, ToolKit> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyToolKitRepository repository;

	// AbstractListService<Administrator, UserAccount> interface --------------


	@Override
	public boolean authorise(final Request<ToolKit> request) {
		assert request != null;

		return true;
	}
	
	@Override
	public Collection<ToolKit> findMany(final Request<ToolKit> request) {
		
		assert request != null;

		Collection<ToolKit> result;
		result = this.repository.findAllToolKits();
		
		return result;
	}
	
	@Override
	public void unbind(final Request<ToolKit> request, final ToolKit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		Collection<Item> components, tools;
		
		tools = components = this.repository.findAllItems();
		
		tools.removeIf(x->x.getType()!=ItemType.TOOL);
		components.removeIf(x->x.getType()!=ItemType.COMPONENT);
		
		
		Money price, tempPrice;
		Collection<Quantity> itemsToolkit;
		
		itemsToolkit = this.repository.findAllItemsFromToolKitById(entity.getId());
		
		price = new Money();
		Double value;
		int amount;
		value = 0.;
		
		Double exchangeUsdToEur, exchangeGbpToEur;
		exchangeUsdToEur = 1/1.08;
		exchangeGbpToEur = 1/0.84;
		
		for(final Quantity q : itemsToolkit) {
			tempPrice = q.getItem().getRetailPrice();
			amount = q.getAmount();
			if(tempPrice.getCurrency().equals("EUR")) {
				value += amount*tempPrice.getAmount();
				price.setCurrency(tempPrice.getCurrency());
			}
			
			else if(tempPrice.getCurrency().equals("USD")) {
				value += amount*tempPrice.getAmount()/exchangeUsdToEur;
			}
			
			else {
				value += amount*tempPrice.getAmount()/exchangeGbpToEur;
			}
		}
		
		
		price.setAmount(value);
		model.setAttribute("toolKitPrice", price);
		
		request.unbind(entity, model, "code", "title");
	}

}
