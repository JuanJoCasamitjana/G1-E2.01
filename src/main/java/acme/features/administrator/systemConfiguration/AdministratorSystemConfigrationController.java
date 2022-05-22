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
	protected AdministratorSystemConfigrationPerformService editService;
	
	@PostConstruct
	protected void initialise() {
		
		super.addCommand("update", this.editService);
	}
}
