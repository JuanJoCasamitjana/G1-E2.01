/*
 * AdministratorUserAccountUpdateService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.any.userAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.entities.UserAccountStatus;
import acme.framework.features.administrator.userAccount.AdministratorUserAccountRepository;
import acme.framework.roles.Any;
import acme.framework.services.AbstractUpdateService;

@Service
public class AnyUserAccountUpdateService implements AbstractUpdateService<Any, UserAccount> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorUserAccountRepository repository;

	// AbstractUpdateService<Any, UserAccount> interface -------------


	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<UserAccount> request, final UserAccount entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		String newStatus;

		newStatus = request.getModel().getString("newStatus");

		if (newStatus.equals("ENABLED")) {
			entity.setEnabled(true);
		} else if (newStatus.equals("DISABLED")) {
			entity.setEnabled(false);
		}
	}

	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "username", "identity.name", "identity.surname", "identity.email");
		model.setAttribute("roleList", entity.getAuthorityString());
		if (entity.isEnabled()) {
			model.setAttribute("status", UserAccountStatus.ENABLED);
		} else {
			model.setAttribute("status", UserAccountStatus.DISABLED);
		}
	}

	@Override
	public UserAccount findOne(final Request<UserAccount> request) {
		assert request != null;

		UserAccount result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneUserAccountById(id);

		return result;
	}

	@Override
	public void validate(final Request<UserAccount> request, final UserAccount entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void update(final Request<UserAccount> request, final UserAccount entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
