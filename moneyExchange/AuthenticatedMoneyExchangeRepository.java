package acme.features.authenticated.moneyExchange;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.components.MoneyExchangeTracking;
import acme.forms.MoneyExchange;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMoneyExchangeRepository extends AbstractRepository{
	
	@Query("select met from MoneyExchangeTracking met")
	Collection<MoneyExchangeTracking> findAllExchanges();
	
	@Query("select met.exchange from MoneyExchangeTracking met where met.id =:")
	MoneyExchange findExchangeById(int id);
}
