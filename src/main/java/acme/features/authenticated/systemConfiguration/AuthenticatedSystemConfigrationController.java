package acme.features.authenticated.systemConfiguration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;
import acme.system.configuration.SystemConfiguration;

@Controller
public class AuthenticatedSystemConfigrationController extends AbstractController<Authenticated, SystemConfiguration> {

	@Autowired
	protected AuthenticatedSystemConfigrationCurrenciesService currenciesService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.currenciesService);
	}
}
