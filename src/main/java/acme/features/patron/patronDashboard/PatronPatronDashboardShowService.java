package acme.features.patron.patronDashboard;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.entities.Status;
import acme.forms.PatronDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronPatronDashboardShowService implements AbstractShowService<Patron, PatronDashboard>{
	
	// Internal state ---------------------------------------------------------
	
	@Autowired	
	PatronPatronDashboardRepository repository;
	
	// AbstractShowService<Patron, PatronDashboard> interface --------------
	
	@Override
	public boolean authorise(final Request<PatronDashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public PatronDashboard findOne(final Request<PatronDashboard> request) {
		assert request != null;
		
		final PatronDashboard result = new PatronDashboard();
		
		final Map<Status, Integer> countPatronageMap = new EnumMap<>(Status.class);
		final List<Object[]> countPatronageCollection = this.repository.totalNumberPatronagesOfStatus();
		for (int i = 0; i < countPatronageCollection.size(); i++) {
			final Status status = (Status) countPatronageCollection.get(i)[0];
			final Long count = (Long) countPatronageCollection.get(i)[1];
			
			countPatronageMap.put(status, count.intValue());
		}
		result.setTotalNumberPatronagesOfStatus(countPatronageMap);
		
		final Map<Pair<Status, String>, Money> avgPatronageMap = new HashMap<>();
		final List<Object[]> avgPatronageCollection = this.repository.averageBudgetPatronagesOfStatusByCurrency();
		for (int i = 0; i < avgPatronageCollection.size(); i++) {
			final Status status = (Status) avgPatronageCollection.get(i)[0];
			final String currency = (String) avgPatronageCollection.get(i)[1];
			final Money m = new Money();
			final Double amount = (Double) avgPatronageCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			avgPatronageMap.put(Pair.of(status, currency), m);
		}
		result.setAverageBudgetPatronagesOfStatusByCurrency(avgPatronageMap);
		
		final Map<Pair<Status, String>, Money> devPatronageMap = new HashMap<>();
		final List<Object[]> devPatronageCollection = this.repository.deviationBudgetPatronagesOfStatusByCurrency();
		for (int i = 0; i < devPatronageCollection.size(); i++) {
			final Status status = (Status) devPatronageCollection.get(i)[0];
			final String currency = (String) devPatronageCollection.get(i)[1];
			final Money m = new Money();
			final Double amount = (Double) devPatronageCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			devPatronageMap.put(Pair.of(status, currency), m);
		}
		result.setDeviationBudgetPatronagesOfStatusByCurrency(devPatronageMap);
		
		final Map<Pair<Status, String>, Money> minPatronageMap = new HashMap<>();
		final List<Object[]> minPatronageCollection = this.repository.minimumBudgetPatronagesOfStatusByCurrency();
		for (int i = 0; i < minPatronageCollection.size(); i++) {
			final Status status = (Status) minPatronageCollection.get(i)[0];
			final String currency = (String) minPatronageCollection.get(i)[1];
			final Money m = new Money();
			final Double amount = (Double) minPatronageCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			minPatronageMap.put(Pair.of(status, currency), m);
		}
		result.setMinimumBudgetPatronagesOfStatusByCurrency(minPatronageMap);
		
		final Map<Pair<Status, String>, Money> maxPatronageMap = new HashMap<>();
		final List<Object[]> maxPatronageCollection = this.repository.maximumBudgetPatronagesOfStatusByCurrency();
		for (int i = 0; i < maxPatronageCollection.size(); i++) {
			final Status status = (Status) maxPatronageCollection.get(i)[0];
			final String currency = (String) maxPatronageCollection.get(i)[1];
			final Money m = new Money();
			final Double amount = (Double) maxPatronageCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			maxPatronageMap.put(Pair.of(status, currency), m);
		}
		result.setMaximumBudgetPatronagesOfStatusByCurrency(maxPatronageMap);
		
		return result;
	}

	@Override
	public void unbind(final Request<PatronDashboard> request, final PatronDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "totalNumberPatronagesOfStatus", "averageBudgetPatronagesOfStatusByCurrency", "deviationBudgetPatronagesOfStatusByCurrency", "minimumBudgetPatronagesOfStatusByCurrency", "maximumBudgetPatronagesOfStatusByCurrency");
	}
}
