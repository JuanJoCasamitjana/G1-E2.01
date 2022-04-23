package acme.features.authenticated.moneyExchange;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.forms.MoneyExchange;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

@Controller
public class AuthenticatedMoneyExchangeController extends AbstractController<Authenticated, MoneyExchange>{

	@Autowired
	protected AuthenticatedMoneyExchangeService exchangeService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("perform", this.exchangeService);
	}
}
