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

package acme.features.anonymous.toolKit;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousToolKitListService implements AbstractListService<Anonymous, ToolKit> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnonymousToolKitRepository repository;

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
				
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "optionalLink");
	}

}
