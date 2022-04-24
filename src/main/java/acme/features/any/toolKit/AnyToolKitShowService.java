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

package acme.features.any.toolKit;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ItemType;
import acme.entities.Quantity;
import acme.entities.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyToolKitShowService implements AbstractShowService<Any, ToolKit> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyToolKitRepository repository;

	// AbstractShowService<Administrator, UserAccount> interface --------------


	@Override
	public boolean authorise(final Request<ToolKit> request) {
		assert request != null;

		return true;
	}

	@Override
	public ToolKit findOne(final Request<ToolKit> request) {
		assert request != null;

		ToolKit result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneToolKitById(id);

		return result;
	}

	@Override
	public void unbind(final Request<ToolKit> request, final ToolKit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Collection<Quantity> tools, components;
		tools = components = this.repository.findAllItemsFromToolKitById(entity.getId());
		
		tools.removeIf(x->x.getItem().getType().equals(ItemType.COMPONENT));
		components.removeIf(x->x.getItem().getType().equals(ItemType.TOOL));
		
		model.setAttribute("toolKitTools", tools);
		model.setAttribute("toolKitComponents", components);
		
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "optionalLink");
	}
	
}
