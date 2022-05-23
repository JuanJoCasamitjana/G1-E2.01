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

package acme.features.inventor.toolKitQuantity;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.entities.Quantity;
import acme.entities.ToolKit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorToolKitQuantityRepository extends AbstractRepository {

	@Query("select q from Quantity q where q.id = :id")
	Quantity findOneQuantityById(int id);

	@Query("select q from Quantity q where q.toolKit.published=1")
	Collection<Quantity> findAllQuantities();
	
	@Query("select it from Item it")
	Collection<Item> findAllItems();
	
	@Query("select q from Quantity q where q.toolKit.id =:id and q.toolKit.published=1")
	Collection<Quantity> findAllItemsFromToolKitById(int id);
	
	@Query("select q from Quantity q where q.toolKit.id =:id")
	Collection<Quantity> findAllItemsFromToolKitByIdAllPublished(int id);
	
	
	
	@Query("select tk from ToolKit tk where tk.id =:id")
	ToolKit findToolKitById(int id);
	
	@Query("select it from Item it where it.code =:code")
	Item findItemByCode(String code);
}
