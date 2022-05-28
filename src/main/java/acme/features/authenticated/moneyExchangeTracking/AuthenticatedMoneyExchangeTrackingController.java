package acme.features.authenticated.moneyExchangeTracking;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.components.MoneyExchangeTracking;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

@Controller
public class AuthenticatedMoneyExchangeTrackingController extends AbstractController<Authenticated, MoneyExchangeTracking>{
	
	@Autowired
	protected AuthenticatedMoneyExchangeTrackingListService listService;
		
	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
	}
}
