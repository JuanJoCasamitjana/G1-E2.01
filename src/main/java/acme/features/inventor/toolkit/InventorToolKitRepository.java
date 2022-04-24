package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.ToolKit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorToolKitRepository extends AbstractRepository{
	
	@Query("select tk from ToolKit tk where tk.inventor.id = :inventorId")
	Collection<ToolKit> findOwnToolkits(int inventorId);
	
	@Query("select tk from ToolKit tk where tk.id = :id")
	ToolKit findOneToolkitById(int id);
	
}
