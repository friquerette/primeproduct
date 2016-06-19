package com.friquerette.primems.controller.web;

import static com.friquerette.primems.controller.web.AbstractWebController.ROOT_HOME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.service.CustomerService;

@Controller
@RequestMapping(ROOT_HOME)
public class AdminController extends AbstractWebController {
	@Autowired(required = true)
	@Qualifier(value = "customerService")
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("customers", this.customerService.findAllCustomers());
		return "admin/admin";
	}
}
