package acme.features.inventor.toolkit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.ToolKit;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorToolKitController extends AbstractController<Inventor, ToolKit>{
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected InventorToolKitListService listService;
	
	@Autowired
	protected InventorToolKitShowService showService;
	
	// Constructors -----------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list", this.listService);
	}
	
}
