package acme.features.patron.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Patronage;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronPatronageRepository extends AbstractRepository {

	@Query("select p from Patronage p where p.id = :id")
	Patronage findOnePatronageById(int id);

	@Query("select p from Patronage p")
	Collection<Patronage> findAllPatronages();
	
	@Query("select p from Patronage p where p.patron.id = :id")
	Collection<Patronage> findPatronagesByPatronId(int id);

}
