package acme.features.inventor.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor,Item> {
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected InventorComponentListService componentListService;
	
	@Autowired
	protected InventorToolListService tooltListService;
	
	@Autowired
	protected InventorItemShowService showService;
	
	@Autowired
	protected InventorItemCreateService createService;
	
	@Autowired
	protected InventorItemDeleteService deleteService;
	
	@Autowired
	protected InventorItemUpdateService updateService;
	
	@Autowired
	protected InventorItemPublishService publishService;
	
	// Constructors -----------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list-component", "list",  this.componentListService);
		super.addCommand("list-tool", "list",  this.tooltListService);
		super.addCommand("show", this.showService);
		super.addCommand("create", this.createService);
		super.addCommand("delete", this.deleteService);
		super.addCommand("update", this.updateService);
		super.addCommand("publish", "update", this.publishService);
	}
	
}
