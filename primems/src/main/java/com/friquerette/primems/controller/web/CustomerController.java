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
@RequestMapping("/account")
public class CustomerController {
	@Autowired(required = true)
	@Qualifier(value = "customerService")
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("customers", this.customerService.findAllCustomers());
		return "account/customers";
	}

}