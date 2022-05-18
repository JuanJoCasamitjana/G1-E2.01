package acme.features.administrator.systemConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;
import acme.system.configuration.SystemConfiguration;

@Service
public class AdministratorSystemConfigrationShowService implements AbstractShowService<Administrator,SystemConfiguration>{

	@Autowired
	protected AdministratorSystemConfigrationRepository repository;

	@Override
	public boolean authorise(final Request<SystemConfiguration> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public SystemConfiguration findOne(final Request<SystemConfiguration> request) {
		
		SystemConfiguration sysConf;
		sysConf = this.repository.getSystemConfiguration();
		
		return sysConf;
	}

	@Override
	public void unbind(final Request<SystemConfiguration> request, final SystemConfiguration entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "acceptedCurrencies","defaultSystemCurrency", "strongSpamTerms", "strongSpamThreshold", "weakSpamTerms", "weakSpamThreshold");
		model.setAttribute("readOnly", true);
		
		
	}
}
