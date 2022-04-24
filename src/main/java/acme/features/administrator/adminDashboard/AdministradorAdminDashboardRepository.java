package acme.features.administrator.adminDashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministradorAdminDashboardRepository extends AbstractRepository{
	
	@Query("select count(i) from Item i where i.type = acme.entities.ItemType.COMPONENT")
	int totalNumberComponents();
	
	@Query("select i.technology, i.retailPrice.currency, avg(i.retailPrice.amount) from Item i where i.type = acme.entities.ItemType.COMPONENT group by i.technology, i.retailPrice.currency")
	List<Object[]> averageRetailPriceComponentsByTechnologyAndCurrency();
	@Query("select i.technology, i.retailPrice.currency, stddev(i.retailPrice.amount) from Item i where i.type = acme.entities.ItemType.COMPONENT group by i.technology, i.retailPrice.currency")
	List<Object[]> deviationRetailPriceComponentsByTechnologyAndCurrency();
	@Query("select i.technology, i.retailPrice.currency, min(i.retailPrice.amount) from Item i where i.type = acme.entities.ItemType.COMPONENT group by i.technology, i.retailPrice.currency")
	List<Object[]> minimumRetailPriceComponentsByTechnologyAndCurrency();
	@Query("select i.technology, i.retailPrice.currency, max(i.retailPrice.amount) from Item i where i.type = acme.entities.ItemType.COMPONENT group by i.technology, i.retailPrice.currency")
	List<Object[]> maximumRetailPriceComponentsByTechnologyAndCurrency();
	
	@Query("select count(i) from Item i where i.type = acme.entities.ItemType.TOOL")
	int totalNumberTools();

	@Query("select i.retailPrice.currency, avg(i.retailPrice.amount) from Item i where i.type = acme.entities.ItemType.TOOL group by i.retailPrice.currency")
	List<Object[]> averageRetailPriceToolsByCurrency();
	@Query("select i.retailPrice.currency, stddev(i.retailPrice.amount) from Item i where i.type = acme.entities.ItemType.TOOL group by i.retailPrice.currency")
	List<Object[]> deviationRetailPriceToolsByCurrency();
	@Query("select i.retailPrice.currency, min(i.retailPrice.amount) from Item i where i.type = acme.entities.ItemType.TOOL group by i.retailPrice.currency")
	List<Object[]> minimumRetailPriceToolsByCurrency();
	@Query("select i.retailPrice.currency, max(i.retailPrice.amount) from Item i where i.type = acme.entities.ItemType.TOOL group by i.retailPrice.currency")
	List<Object[]> maximumRetailPriceToolsByCurrency();

	@Query("select p.status, count(p) from Patronage p group by p.status")
	List<Object[]> totalNumberPatronagesOfStatus();

	@Query("select p.status, p.budget.currency, avg(p.budget.amount) from Patronage p group by p.status")
	List<Object[]> averageBudgetPatronagesOfStatus();
	@Query("select p.status, p.budget.currency, stddev(p.budget.amount) from Patronage p group by p.status")
	List<Object[]> deviationBudgetPatronagesOfStatus();
	@Query("select p.status, p.budget.currency, min(p.budget.amount) from Patronage p group by p.status")
	List<Object[]> minimumBudgetPatronagesOfStatus();
	@Query("select p.status, p.budget.currency, max(p.budget.amount) from Patronage p group by p.status")
	List<Object[]> maximumBudgetPatronagesOfStatus();
	
	@Query("select distinct i.retailPrice.currency from Item i")
	List<String> getAllCurrencies();
	@Query("select distinct i.technology from Item i")
	List<String> getAllTechnologies();
	
	
}
