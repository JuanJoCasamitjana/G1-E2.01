package acme.features.authenticated.money;

import org.springframework.stereotype.Repository;

import acme.framework.datatypes.Money;
import acme.framework.repositories.AbstractRepository;
@Repository
public interface AuthenticatedMoneyRepository extends AbstractRepository {

	Money findOneMoney(int id);

}
