package acme.components;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface SystemConfigurationRepository extends AbstractRepository{
	
	@Query("select sc.strongSpamTerms from SystemConfiguration sc")
	String getStrongSpamTerms();
	
	@Query("select sc.weakSpamTerms from SystemConfiguration sc")
	String getWeakSpamTerms();
	
	@Query("select sc.strongSpamThreshold from SystemConfiguration sc")
	Double getStrongSpamThreshold();
	
	@Query("select sc.weakSpamThreshold from SystemConfiguration sc")
	Double getWeakSpamThreshold();
	
}
