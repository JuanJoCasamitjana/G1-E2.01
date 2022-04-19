package acme.features.authenticated.money;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMoneyShowService implements AbstractShowService<Authenticated,Money>{

	@Autowired
	protected AuthenticatedMoneyRepository repository;
	
	@Override
	public boolean authorise(final Request<Money> request) {
		// TODO Auto-generated method stub
		assert request != null;
		return true;
	}

	@Override
	public Money findOne(final Request<Money> request) {
		// TODO Auto-generated method stub
		assert request != null;
		int id;
		Money result;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneMoney(id);
		return result;
	}

	@Override
	public void unbind(final Request<Money> request, final Money entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "currency", "amount");
	}

}
