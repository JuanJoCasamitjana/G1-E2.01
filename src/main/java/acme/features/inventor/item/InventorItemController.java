package acme.features.inventor.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor,Item> {
	@Autowired
	protected InventorComponentListService componentListService;
	@Autowired
	protected InventorToolListService tooltListService;
	@Autowired
	protected InventorItemShowService showService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list-component", this.componentListService);
		super.addCommand("list-tool", this.tooltListService);
		super.addCommand("show", this.showService);
	}
	
}
