package acme.features.authenticated.moneyExchange;

import org.springframework.beans.factory.annotation.Autowired;

import acme.forms.MoneyExchange;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractShowService;

public class AuthenticatedMoneyExchangeShowService implements AbstractShowService<Authenticated, MoneyExchange>{
	
	@Autowired
	protected AuthenticatedMoneyExchangeRepository repository;
	
	@Override
	public boolean authorise(final Request<MoneyExchange> request) {
		assert request != null;
		return true;
	}

	@Override
	public MoneyExchange findOne(final Request<MoneyExchange> request) {
		MoneyExchange result;
		int exchangeId;
		
		exchangeId = request.getModel().getInteger("id");
		
		result = this.repository.findExchangeById(exchangeId);
		return result;
	}

	@Override
	public void unbind(final Request<MoneyExchange> request, final MoneyExchange entity, final Model model) {
		// TODO Auto-generated method stub
		
	}

}
