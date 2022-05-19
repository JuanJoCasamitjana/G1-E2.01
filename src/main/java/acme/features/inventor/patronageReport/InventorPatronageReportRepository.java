package acme.features.inventor.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Patronage;
import acme.entities.PatronageReport;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorPatronageReportRepository extends AbstractRepository {

	@Query("select p from PatronageReport p where p.id = :id")
	PatronageReport findOnePatronageReportById(int id);

	@Query("select p from PatronageReport p")
	Collection<PatronageReport> findAllPatronageReports();
	
	@Query("select p from PatronageReport p where p.patronage.inventor.id = :id")
	Collection<PatronageReport> findPatronageReportsByInventorId(int id);

	@Query("select p from Patronage p where p.inventor.id = :id")
	Collection<Patronage> findAllPatronagesByInventorId(int id);
	
	@Query("select p from Patronage p where p.code = :code")
	Patronage findPatronageByCode(String code);

}
