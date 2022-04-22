package acme.features.administrator.adminDashboard;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

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
		
		final AdminDashboard result;
		
		// Components
		
		final int totalNumberComponents = this.repository.totalNumberComponents();
		result.setTotalNumberComponents(totalNumberComponents);
		
		final Map<Pair<String, String>, Money> avgComponentsMap;
		final List<Object[]> avgComponentsCollection = this.repository.averageRetailPriceComponentsByTechnologyAndCurrency();
		for (int i = 0; i < avgComponentsCollection.size(); i++) {
			final String technology = (String) avgComponentsCollection.get(i)[0];
			final String currency = (String) avgComponentsCollection.get(i)[1];
			final Money m;
			final Double amount = (Double) avgComponentsCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			avgComponentsMap.put(Pair.of(technology, currency), m);
		}
		result.setAverageRetailPriceComponentsByTechnologyAndCurrency(avgComponentsMap);
		
		final Map<Pair<String, String>, Money> devComponentsMap;
		final List<Object[]> devComponentsCollection = this.repository.deviationRetailPriceComponentsByTechnologyAndCurrency();
		for (int i = 0; i < devComponentsCollection.size(); i++) {
			final String technology = (String) devComponentsCollection.get(i)[0];
			final String currency = (String) devComponentsCollection.get(i)[1];
			final Money m;
			final Double amount = (Double) devComponentsCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			devComponentsMap.put(Pair.of(technology, currency), m);
		}
		result.setDeviationRetailPriceComponentsByTechnologyAndCurrency(devComponentsMap);
		
		final Map<Pair<String, String>, Money> minComponentsMap;
		final List<Object[]> minComponentsCollection = this.repository.minimumRetailPriceComponentsByTechnologyAndCurrency();
		for (int i = 0; i < minComponentsCollection.size(); i++) {
			final String technology = (String) minComponentsCollection.get(i)[0];
			final String currency = (String) minComponentsCollection.get(i)[1];
			final Money m;
			final Double amount = (Double) minComponentsCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			minComponentsMap.put(Pair.of(technology, currency), m);
		}
		result.setMinimumRetailPriceComponentsByTechnologyAndCurrency(minComponentsMap);
		
		final Map<Pair<String, String>, Money> maxComponentsMap;
		final List<Object[]> maxComponentsCollection = this.repository.maximumRetailPriceComponentsByTechnologyAndCurrency();
		for (int i = 0; i < maxComponentsCollection.size(); i++) {
			final String technology = (String) maxComponentsCollection.get(i)[0];
			final String currency = (String) maxComponentsCollection.get(i)[1];
			final Money m;
			final Double amount = (Double) maxComponentsCollection.get(i)[2];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			maxComponentsMap.put(Pair.of(technology, currency), m);
		}
		result.setMaximumRetailPriceComponentsByTechnologyAndCurrency(maxComponentsMap);
		
		// Tools
		
		final int totalNumberTools = this.repository.totalNumberTools();
		result.setTotalNumberTools(totalNumberTools);
		
		final Map<String, Money> avgToolsMap;
		final List<Object[]> avgToolsCollection = this.repository.averageRetailPriceToolsByCurrency();
		for (int i = 0; i < avgToolsCollection.size(); i++) {
			final String currency = (String) avgToolsCollection.get(i)[0];
			final Money m;
			final Double amount = (Double) avgToolsCollection.get(i)[1];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			avgToolsMap.put(currency, m);
		}
		result.setAverageRetailPriceToolsByCurrency(avgToolsMap);
		
		final Map<String, Money> devToolsMap;
		final List<Object[]> devToolsCollection = this.repository.deviationRetailPriceToolsByCurrency();
		for (int i = 0; i < devToolsCollection.size(); i++) {
			final String currency = (String) devToolsCollection.get(i)[0];
			final Money m;
			final Double amount = (Double) devToolsCollection.get(i)[1];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			devToolsMap.put(currency, m);
		}
		result.setDeviationRetailPriceToolsByCurrency(devToolsMap);
		
		final Map<String, Money> minToolsMap;
		final List<Object[]> minToolsCollection = this.repository.minimumRetailPriceToolsByCurrency();
		for (int i = 0; i < minToolsCollection.size(); i++) {
			final String currency = (String) minToolsCollection.get(i)[0];
			final Money m;
			final Double amount = (Double) minToolsCollection.get(i)[1];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			minToolsMap.put(currency, m);
		}
		result.setMinimumRetailPriceToolsByCurrency(minToolsMap);
		
		final Map<String, Money> maxToolsMap;
		final List<Object[]> maxToolsCollection = this.repository.maximumRetailPriceToolsByCurrency();
		for (int i = 0; i < maxToolsCollection.size(); i++) {
			final String currency = (String) maxToolsCollection.get(i)[0];
			final Money m;
			final Double amount = (Double) maxToolsCollection.get(i)[1];
			m.setAmount(amount);
			m.setCurrency(currency);
			
			maxToolsMap.put(currency, m);
		}
		result.setMaximumRetailPriceToolsByCurrency(maxToolsMap);
		
		//Patronage
		
//		final Map<String, Money> countPatronageMap;
//		final List<Object[]> countPatronageCollection = this.repository.totalNumberPatronagesOfStatus();
//		for (int i = 0; i < countPatronageCollection.size(); i++) {
//			final String status = (String) countPatronageCollection.get(i)[0];
//			final Money m;
//			final Double amount = (Double) countPatronageCollection.get(i)[1];
//			m.setAmount(amount);
//			m.setCurrency(currency);
//			
//			countPatronageMap.put(currency, m);
//		}
//		result.setMaximumRetailPriceToolsByCurrency(countPatronageMap);
		
		return result;
	}

	@Override
	public void unbind(final Request<AdminDashboard> request, final AdminDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "");
	}
	
}
