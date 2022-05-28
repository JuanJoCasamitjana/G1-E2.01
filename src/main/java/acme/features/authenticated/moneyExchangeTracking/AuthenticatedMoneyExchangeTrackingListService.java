package acme.features.authenticated.moneyExchangeTracking;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.MoneyExchangeTracking;
import acme.forms.MoneyExchange;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMoneyExchangeTrackingListService implements AbstractListService<Authenticated, MoneyExchangeTracking>{
	
	@Autowired
	protected AuthenticatedMoneyExchangeTrackingRepository repository;
	
	@Override
	public boolean authorise(final Request<MoneyExchangeTracking> request) {
		assert request != null;
		return true;
	}

	@Override
	public Collection<MoneyExchangeTracking> findMany(final Request<MoneyExchangeTracking> request) {
		assert request != null;
		
		Collection<MoneyExchangeTracking> result;
		result = this.repository.findAllExchanges();
		
		return result;
	}

	@Override
	public void unbind(final Request<MoneyExchangeTracking> request, final MoneyExchangeTracking entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		MoneyExchange me;
		me = entity.getExchange();
		
		model.setAttribute("source", me.getSource().toString());
		model.setAttribute("target", me.getTarget().toString());
		model.setAttribute("date", me.getDate());
	}
}
