package com.friquerette.primems.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.friquerette.primems.entity.Customer;
import com.friquerette.primems.service.CustomerService;

@RestController
public class HelloWorldRestController {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldRestController.class);

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getUser() {
		try {
			customerService.findAllCustomers();
		} catch (Exception e) {
			logger.error("Failed to read all the customers", e);
		}

		System.out.println("Fetching Customer with id ");
		Customer customer = new Customer("Franck", "Martin");
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{firstname}/{lastname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> createUser(//
			@PathVariable("firstname") String firstname, //
			@PathVariable("lastname") String lastname) {
		System.out.println("Fetching Customer with id ");
		Customer customer = new Customer(firstname, lastname);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
