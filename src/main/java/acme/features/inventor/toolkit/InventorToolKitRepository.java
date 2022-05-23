package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.ToolKit;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorToolKitRepository extends AbstractRepository{
	
	@Query("select tk from ToolKit tk where tk.inventor.id = :inventorId")
	Collection<ToolKit> findOwnToolkits(int inventorId);
	
	@Query("select tk from ToolKit tk where tk.id = :id")
	ToolKit findOneToolkitById(int id);
	
	@Query("select tk from ToolKit tk where tk.code = :code")
	ToolKit findToolKitByCode(String code);
	
	@Query("select i from Inventor i where i.id = :id")
	Inventor findInventorById(int id);
	
	@Query("select count(*) from Quantity q where q.toolKit.code =:code")
	Integer countItemsInToolKitByCode(String code);
	
	@Query("select count(*) from ToolKit tk where tk.code =:code")
	Integer countToolKitsWithCode(String code);
}
