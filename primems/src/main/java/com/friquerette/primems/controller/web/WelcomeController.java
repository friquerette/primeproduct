package com.friquerette.primems.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.service.CustomerService;

@Controller
@RequestMapping("/")
public class WelcomeController extends AbstractWebController {
	@Autowired(required = true)
	@Qualifier(value = "customerService")
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("customers", this.customerService.findAllCustomers());
		return "customers";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("customers", this.customerService.findAllCustomers());
		return "index";
	}

}
