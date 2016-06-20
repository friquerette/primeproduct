package com.friquerette.primems.controller.rest;

import java.util.List;

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

import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.service.CustomerService;

@RestController
@RequestMapping(RestConstant.ROOT_WS + RestConstant.CUSTOMER)
public class CustomerRestController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerRestController.class);

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = RestConstant.ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getUser() {
		List<Customer> customers = null;
		try {
			customers = customerService.findAll();
		} catch (Exception e) {
			logger.error("Failed to read all the customers", e);
		}

		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	@RequestMapping(value = RestConstant.BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCategoryById(@PathVariable("id") Long id) {
		Customer category = null;
		try {
			category = customerService.findById(id);
		} catch (Exception e) {
			logger.error("Failed to read customer for the id " + id, e);
		}
		return new ResponseEntity<Customer>(category, HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/{firstname}/{lastname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> createUser(//
			@PathVariable("firstname") String firstname, //
			@PathVariable("lastname") String lastname) {
		logger.info("Fetching Customer with id ");
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
