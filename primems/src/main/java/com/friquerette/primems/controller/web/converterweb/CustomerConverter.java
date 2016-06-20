package com.friquerette.primems.controller.web.converterweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.friquerette.primems.controller.web.webmodel.CustomerWeb;
import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.service.CustomerService;

/**
 * A converter Entity Model/Web Model for the Customer
 * 
 * This converter avoid lazy exception... and allow to determined which field
 * could be update
 */
@Component
public class CustomerConverter implements WebModelConverter<Customer, CustomerWeb> {

	@Autowired(required = true)
	@Qualifier(value = "customerService")
	private CustomerService customerService;

	public Customer fromWeb(CustomerWeb web) {
		Customer customer = null;
		if (web != null) {
			if (web.getId() == null) {
				customer = customerService.getInstance();
			} else {
				customer = customerService.findById(web.getId());
			}
			customer.setId(web.getId());
			customer.setFirstName(web.getFirstName());
			customer.setLastName(web.getLastName());
			customer.setUserName(web.getUserName());
			customer.setPassword(web.getPassword());
			customer.setEmail(web.getEmail());
			// customer.setRole(web.getRole());
			// customer.setGender(web.getGender());
		}
		return customer;
	}

	public CustomerWeb toWeb(Customer customer) {
		if (customer == null) {
			customer = customerService.getInstance();
		}
		CustomerWeb web = new CustomerWeb();
		web.setId(customer.getId());
		web.setFirstName(customer.getFirstName());
		web.setLastName(customer.getLastName());
		web.setUserName(customer.getUserName());
		web.setPassword(customer.getPassword());
		web.setEmail(customer.getEmail());
		web.setRole(customer.getRole());
		web.setGender(customer.getGender());
		return web;
	}
}
