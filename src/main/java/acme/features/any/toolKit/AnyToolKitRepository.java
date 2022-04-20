/*
 * AdministratorUserAccountRepository.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.any.toolKit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.ToolKit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyToolKitRepository extends AbstractRepository {

	@Query("select tk from ToolKit tk where tk.id = :id")
	ToolKit findOneToolKitById(int id);

	@Query("select tk from ToolKit tk")
	Collection<ToolKit> findAllToolKits();

}
