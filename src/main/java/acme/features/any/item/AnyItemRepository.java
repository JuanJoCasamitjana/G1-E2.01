package acme.features.any.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.entities.ItemType;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyItemRepository extends AbstractRepository{

	@Query("select i from Item i where i.id = :id")
	Item findOneItemByIde(int id);
	
	@Query("select i from Item i where i.type = :type")
	Collection<Item> findAllByType(ItemType type);
}
