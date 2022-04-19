package acme.features.authenticated.money;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.framework.controllers.AbstractController;
import acme.framework.datatypes.Money;
import acme.framework.roles.Authenticated;

@Controller
public class AuthenticatedMoneyController extends AbstractController<Authenticated,Money>{

	@Autowired
	protected AuthenticatedMoneyListService listService;
	
	@Autowired
	protected AuthenticatedMoneyShowService showService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
	}
}
