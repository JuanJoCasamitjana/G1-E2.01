package acme.features.administrator.systemConfiguration;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractListService;
import acme.system.configuration.SystemConfiguration;

@Service
public class AdministratorSystemConfigrationListService implements AbstractListService<Administrator,SystemConfiguration>{

	@Autowired
	protected AdministratorSystemConfigrationRepository repository;

	@Override
	public boolean authorise(final Request<SystemConfiguration> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void unbind(final Request<SystemConfiguration> request, final SystemConfiguration entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "acceptedCurrencies","defaultSystemCurrency", "strongSpamTerms", "strongSpamThreshold", "weakSpamTerms", "weakSpamThreshold");
		
		
		
	}

	@Override
	public Collection<SystemConfiguration> findMany(final Request<SystemConfiguration> request) {
		Collection<SystemConfiguration> result;
		
		result = this.repository.findAllSystemConfiguration();
		
		return result;
	}
}
