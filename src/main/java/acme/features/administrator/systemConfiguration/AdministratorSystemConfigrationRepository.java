package acme.features.administrator.systemConfiguration;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;
import acme.system.configuration.SystemConfiguration;

@Repository
public interface AdministratorSystemConfigrationRepository extends AbstractRepository {

	@Query("select i from SystemConfiguration i")
	Collection<SystemConfiguration> findAllSystemConfiguration();

}
