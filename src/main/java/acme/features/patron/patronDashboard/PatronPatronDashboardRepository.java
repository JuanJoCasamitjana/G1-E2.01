package acme.features.patron.patronDashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronPatronDashboardRepository extends AbstractRepository{
	
	@Query("select p.status, count(p) from Patronage p group by p.status")
	List<Object[]> totalNumberPatronagesOfStatus();
	
	@Query("select p.status, p.budget.currency, avg(p.budget.amount) from Patronage p group by p.status, p.budget.currency")
	List<Object[]> averageBudgetPatronagesOfStatusByCurrency();
	
	@Query("select p.status, p.budget.currency, stddev(p.budget.amount) from Patronage p group by p.status, p.budget.currency")
	List<Object[]> deviationBudgetPatronagesOfStatusByCurrency();
	
	@Query("select p.status, p.budget.currency, min(p.budget.amount) from Patronage p group by p.status, p.budget.currency")
	List<Object[]> minimumBudgetPatronagesOfStatusByCurrency();
	
	@Query("select p.status, p.budget.currency, max(p.budget.amount) from Patronage p group by p.status, p.budget.currency")
	List<Object[]> maximumBudgetPatronagesOfStatusByCurrency();
}
