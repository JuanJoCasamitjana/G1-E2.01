package acme.features.authenticated.money;

import java.util.Collection;

import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractListService;
@Service
public class AuthenticatedMoneyListService implements AbstractListService<Authenticated,Money> {

	@Override
	public boolean authorise(final Request<Money> request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Money> findMany(final Request<Money> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unbind(final Request<Money> request, final Money entity, final Model model) {
		// TODO Auto-generated method stub
		
	}

}
