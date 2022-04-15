/*
 * AuthenticatedPatronageRepository.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.inventor.patronage;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Patronage;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorPatronageRepository extends AbstractRepository {

	@Query("select a from Patronage a where a.id = :id")
	Patronage findOnePatronageById(int id);

	@Query("select a from Patronage a")
	Collection<Patronage> findAllPatronages();

	@Query("select a from Patronage a where a.creationDate > :deadline")
	Collection<Patronage> findRecentPatronages(Date deadline);

}
