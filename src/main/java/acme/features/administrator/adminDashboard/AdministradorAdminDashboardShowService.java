package acme.features.administrator.adminDashboard;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.entities.Status;
import acme.forms.AdminDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministradorAdminDashboardShowService implements AbstractShowService<Administrator, AdminDashboard>{
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	AdministradorAdminDashboardRepository repository;

	// AbstractShowService<Administrator, AdminDashboard> interface --------------
	
	@Override
	public boolean authorise(final Request<AdminDashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public AdminDashboard findOne(final Request<AdminDashboard> request) {
		assert request != null;
		
		final AdminDashboard result = new AdminDashboard();
		
		// Components metrics
		
		final int totalNumberComponents = this.repository.totalNumberComponents();
		result.setTotalNumberComponents(totalNumberComponents);
		
		final Map<Pair<String, String>, Money> avgComponentsMap = new HashMap<>();
		final List<Object[]> avgComponentsCollection = this.repository.averageRetailPriceComponentsByTechnologyAndCurrency();
		for (int i = 0; i < avgComponentsCollection.size(); i++) {
			final String technology = (String) avgComponentsCollection.get(i)[0];
			final String currency = (String) avgComponentsCollection.get(i)[1];
			final Money m = new Money();
			final Double amount = (Double) avgComponentsCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			avgComponentsMap.put(Pair.of(technology, currency), m);
		}
		result.setAverageRetailPriceComponentsByTechnologyAndCurrency(avgComponentsMap);
		
		final Map<Pair<String, String>, Money> devComponentsMap = new HashMap<>();
		final List<Object[]> devComponentsCollection = this.repository.deviationRetailPriceComponentsByTechnologyAndCurrency();
		for (int i = 0; i < devComponentsCollection.size(); i++) {
			final String technology = (String) devComponentsCollection.get(i)[0];
			final String currency = (String) devComponentsCollection.get(i)[1];
			final Money m = new Money();
			final Double amount = (Double) devComponentsCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			devComponentsMap.put(Pair.of(technology, currency), m);
		}
		result.setDeviationRetailPriceComponentsByTechnologyAndCurrency(devComponentsMap);
		
		final Map<Pair<String, String>, Money> minComponentsMap = new HashMap<>();
		final List<Object[]> minComponentsCollection = this.repository.minimumRetailPriceComponentsByTechnologyAndCurrency();
		for (int i = 0; i < minComponentsCollection.size(); i++) {
			final String technology = (String) minComponentsCollection.get(i)[0];
			final String currency = (String) minComponentsCollection.get(i)[1];
			final Money m = new Money();
			final Double amount = (Double) minComponentsCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			minComponentsMap.put(Pair.of(technology, currency), m);
		}
		result.setMinimumRetailPriceComponentsByTechnologyAndCurrency(minComponentsMap);
		
		final Map<Pair<String, String>, Money> maxComponentsMap = new HashMap<>();
		final List<Object[]> maxComponentsCollection = this.repository.maximumRetailPriceComponentsByTechnologyAndCurrency();
		for (int i = 0; i < maxComponentsCollection.size(); i++) {
			final String technology = (String) maxComponentsCollection.get(i)[0];
			final String currency = (String) maxComponentsCollection.get(i)[1];
			final Money m = new Money();
			final Double amount = (Double) maxComponentsCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			maxComponentsMap.put(Pair.of(technology, currency), m);
		}
		result.setMaximumRetailPriceComponentsByTechnologyAndCurrency(maxComponentsMap);
		
		// Tools metrics
		
		final int totalNumberTools = this.repository.totalNumberTools();
		result.setTotalNumberTools(totalNumberTools);
		
		final Map<String, Money> avgToolsMap = new HashMap<>();
		final List<Object[]> avgToolsCollection = this.repository.averageRetailPriceToolsByCurrency();
		for (int i = 0; i < avgToolsCollection.size(); i++) {
			final String currency = (String) avgToolsCollection.get(i)[0];
			final Money m = new Money();
			final Double amount = (Double) avgToolsCollection.get(i)[1];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			avgToolsMap.put(currency, m);
		}
		result.setAverageRetailPriceToolsByCurrency(avgToolsMap);
		
		final Map<String, Money> devToolsMap = new HashMap<>();
		final List<Object[]> devToolsCollection = this.repository.deviationRetailPriceToolsByCurrency();
		for (int i = 0; i < devToolsCollection.size(); i++) {
			final String currency = (String) devToolsCollection.get(i)[0];
			final Money m = new Money();
			final Double amount = (Double) devToolsCollection.get(i)[1];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			devToolsMap.put(currency, m);
		}
		result.setDeviationRetailPriceToolsByCurrency(devToolsMap);
		
		final Map<String, Money> minToolsMap = new HashMap<>();
		final List<Object[]> minToolsCollection = this.repository.minimumRetailPriceToolsByCurrency();
		for (int i = 0; i < minToolsCollection.size(); i++) {
			final String currency = (String) minToolsCollection.get(i)[0];
			final Money m = new Money();
			final Double amount = (Double) minToolsCollection.get(i)[1];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			minToolsMap.put(currency, m);
		}
		result.setMinimumRetailPriceToolsByCurrency(minToolsMap);
		
		final Map<String, Money> maxToolsMap = new HashMap<>();
		final List<Object[]> maxToolsCollection = this.repository.maximumRetailPriceToolsByCurrency();
		for (int i = 0; i < maxToolsCollection.size(); i++) {
			final String currency = (String) maxToolsCollection.get(i)[0];
			final Money m = new Money();
			final Double amount = (Double) maxToolsCollection.get(i)[1];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			maxToolsMap.put(currency, m);
		}
		result.setMaximumRetailPriceToolsByCurrency(maxToolsMap);
		
		//Patronage metrics
		
		final Map<Status, Integer> countPatronageMap = new EnumMap<>(Status.class);
		final List<Object[]> countPatronageCollection = this.repository.totalNumberPatronagesOfStatus();
		for (int i = 0; i < countPatronageCollection.size(); i++) {
			final Status status = (Status) countPatronageCollection.get(i)[0];
			final Long count = (Long) countPatronageCollection.get(i)[1];
			
			countPatronageMap.put(status, count.intValue());
		}
		result.setTotalNumberPatronagesOfStatus(countPatronageMap);
		
		final Map<Status, Money> averagePatronageMap = new EnumMap<>(Status.class);
		final List<Object[]> averagePatronageCollection = this.repository.averageBudgetPatronagesOfStatus();
		for (int i = 0; i < averagePatronageCollection.size(); i++) {
			final Status status = (Status) averagePatronageCollection.get(i)[0];
			final Money m = new Money();
			final String currency = (String) averagePatronageCollection.get(i)[1];
			final Double amount = (Double) averagePatronageCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			averagePatronageMap.put(status, m);
		}
		result.setAverageBudgetPatronagesOfStatus(averagePatronageMap);
		
		final Map<Status, Money> deviationPatronageMap = new EnumMap<>(Status.class);
		final List<Object[]> deviationPatronageCollection = this.repository.deviationBudgetPatronagesOfStatus();
		for (int i = 0; i < deviationPatronageCollection.size(); i++) {
			final Status status = (Status) deviationPatronageCollection.get(i)[0];
			final Money m = new Money();
			final String currency = (String) deviationPatronageCollection.get(i)[1];
			final Double amount = (Double) deviationPatronageCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			deviationPatronageMap.put(status, m);
		}
		result.setDeviationBudgetPatronagesOfStatus(deviationPatronageMap);
		
		final Map<Status, Money> minimumPatronageMap = new EnumMap<>(Status.class);
		final List<Object[]> minimumPatronageCollection = this.repository.minimumBudgetPatronagesOfStatus();
		for (int i = 0; i < minimumPatronageCollection.size(); i++) {
			final Status status = (Status) minimumPatronageCollection.get(i)[0];
			final Money m = new Money();
			final String currency = (String) minimumPatronageCollection.get(i)[1];
			final Double amount = (Double) minimumPatronageCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			minimumPatronageMap.put(status, m);
		}
		result.setMinimumBudgetPatronagesOfStatus(minimumPatronageMap);
		
		final Map<Status, Money> maximumPatronageMap = new EnumMap<>(Status.class);
		final List<Object[]> maximumPatronageCollection = this.repository.maximumBudgetPatronagesOfStatus();
		for (int i = 0; i < maximumPatronageCollection.size(); i++) {
			final Status status = (Status) maximumPatronageCollection.get(i)[0];
			final Money m = new Money();
			final String currency = (String) maximumPatronageCollection.get(i)[1];
			final Double amount = (Double) maximumPatronageCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			maximumPatronageMap.put(status, m);
		}
		result.setMaximumBudgetPatronagesOfStatus(maximumPatronageMap);
		
		return result;
	}

	@Override
	public void unbind(final Request<AdminDashboard> request, final AdminDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		model.setAttribute("allCurrencies", this.repository.getAllCurrencies());
		model.setAttribute("allTechnologies", this.repository.getAllTechnologies());
		
		request.unbind(entity, model, "totalNumberComponents", "averageRetailPriceComponentsByTechnologyAndCurrency", "deviationRetailPriceComponentsByTechnologyAndCurrency", "minimumRetailPriceComponentsByTechnologyAndCurrency", "maximumRetailPriceComponentsByTechnologyAndCurrency",
			"totalNumberTools", "averageRetailPriceToolsByCurrency", "deviationRetailPriceToolsByCurrency", "minimumRetailPriceToolsByCurrency", "maximumRetailPriceToolsByCurrency", 
			"totalNumberPatronagesOfStatus", "averageBudgetPatronagesOfStatus", "deviationBudgetPatronagesOfStatus", "minimumBudgetPatronagesOfStatus", "maximumBudgetPatronagesOfStatus");
	}
	
}
