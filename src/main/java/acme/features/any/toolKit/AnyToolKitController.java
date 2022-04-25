/*
 * AdministratorUserAccountController.java
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

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.ToolKit;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
@RequestMapping("/any/tool-kit/")
public class AnyToolKitController extends AbstractController<Any, ToolKit> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyToolKitListService	listService;
	
	@Autowired
	protected AnyToolKitFilterListService	listFilterService;
	
	@Autowired
	protected AnyToolKitShowService	showService;
	
	
	
	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("list-filter", "list", this.listFilterService);
		super.addCommand("show", this.showService);
	}

}
