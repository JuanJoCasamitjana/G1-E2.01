package acme.features.administrator.systemConfiguration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.framework.controllers.AbstractController;
import acme.framework.roles.Administrator;
import acme.system.configuration.SystemConfiguration;

@Controller
public class AdministratorSystemConfigrationController extends AbstractController<Administrator, SystemConfiguration> {

	@Autowired
	protected AdministratorSystemConfigrationShowService currenciesService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.currenciesService);
	}
}
