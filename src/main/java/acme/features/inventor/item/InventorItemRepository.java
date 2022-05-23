package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.entities.ItemType;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;
@Repository
public interface InventorItemRepository extends AbstractRepository{
	
	@Query("select i from Item i where i.type = :type and i.inventor.id = :id")
	Collection<Item> findItemsByInventorIdAndItemType(int id, ItemType type);
	
	@Query("select i from Item i where i.id = :id")
	Item findOneItemByItemId(int id);
	
	@Query("select i from Item i where i.code = :code")
	Item findItemByCode(String code);
	
	@Query("select i from Inventor i where i.id = :id")
	Inventor findInventorById(int id);

	@Query("select sc.acceptedCurrencies from SystemConfiguration sc")
	String findAcceptedCurrencies();
	
}
