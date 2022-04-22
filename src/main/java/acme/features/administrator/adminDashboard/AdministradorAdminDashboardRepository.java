package acme.features.administrator.adminDashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministradorAdminDashboardRepository extends AbstractRepository{
	
	@Query("select count(i) from Item i where i.type = acme.entities.item.type.COMPONENT")
	int totalNumberComponents();
	
	@Query("select i.technology, i.retailPrice.currency, avg(i.retailPrice.amount) from Item i where i.type = acme.entities.item.type.COMPONENT group by i.status, i.retailPrice.currency")
	List<Object[]> averageRetailPriceComponentsByTechnologyAndCurrency();
	@Query("select i.technology, i.retailPrice.currency, stddev(i.retailPrice.amount) from Item i where i.type = acme.entities.item.type.COMPONENT group by i.status, i.retailPrice.currency")
	List<Object[]> deviationRetailPriceComponentsByTechnologyAndCurrency();
	@Query("select i.technology, i.retailPrice.currency, min(i.retailPrice.amount) from Item i where i.type = acme.entities.item.type.COMPONENT group by i.status, i.retailPrice.currency")
	List<Object[]> minimumRetailPriceComponentsByTechnologyAndCurrency();
	@Query("select i.technology, i.retailPrice.currency, max(i.retailPrice.amount) from Item i where i.type = acme.entities.item.type.COMPONENT group by i.status, i.retailPrice.currency")
	List<Object[]> maximumRetailPriceComponentsByTechnologyAndCurrency();
	
	@Query("select count(i) from Item i where i.type = acme.entities.item.type.TOOL")
	int totalNumberTools();

	@Query("select i.retailPrice.currency, avg(i.retailPrice.amount) from Item i where i.type = acme.entities.item.type.TOOL group by i.retailPrice.currency")
	List<Object[]> averageRetailPriceToolsByCurrency();
	@Query("select i.retailPrice.currency, stddev(i.retailPrice.amount) from Item i where i.type = acme.entities.item.type.TOOL group by i.retailPrice.currency")
	List<Object[]> deviationRetailPriceToolsByCurrency();
	@Query("select i.retailPrice.currency, min(i.retailPrice.amount) from Item i where i.type = acme.entities.item.type.TOOL group by i.retailPrice.currency")
	List<Object[]> minimumRetailPriceToolsByCurrency();
	@Query("select i.retailPrice.currency, max(i.retailPrice.amount) from Item i where i.type = acme.entities.item.type.TOOL group by i.retailPrice.currency")
	List<Object[]> maximumRetailPriceToolsByCurrency();

	@Query("select p.status, count(p) from Patronage p group by p.status")
	List<Object[]> totalNumberPatronagesOfStatus();

	@Query("select p.status, avg(p.budget.amount) from Patronage p group by p.status")
	List<Object[]> averageBudgetPatronagesOfStatus();
	@Query("select p.status, stddev(p.budget.amount) from Patronage p group by p.status")
	List<Object[]> deviationBudgetPatronagesOfStatus();
	@Query("select p.status, min(p.budget.amount) from Patronage p group by p.status")
	List<Object[]> minimumBudgetPatronagesOfStatus();
	@Query("select p.status, max(p.budget.amount) from Patronage p group by p.status")
	List<Object[]> maximumBudgetPatronagesOfStatus();
	
}
