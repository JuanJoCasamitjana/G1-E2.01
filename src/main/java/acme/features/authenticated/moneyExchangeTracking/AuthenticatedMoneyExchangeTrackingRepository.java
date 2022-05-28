package acme.features.authenticated.moneyExchangeTracking;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.components.MoneyExchangeTracking;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMoneyExchangeTrackingRepository extends AbstractRepository{
	
	@Query("select met from MoneyExchangeTracking met")
	Collection<MoneyExchangeTracking> findAllExchanges();
	
	@Query("select met.exchange from MoneyExchangeTracking met where met.id =:id")
	MoneyExchangeTracking findExchangeById(int id);
}
