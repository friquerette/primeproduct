package com.friquerette.primejs.controller.web.converterweb;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.friquerette.primejs.controller.web.webmodel.CustomerWeb;
import com.friquerette.primejs.core.entity.Customer;
import com.friquerette.primejs.core.entity.GenderEnum;
import com.friquerette.primejs.core.entity.RoleEnum;
import com.friquerette.primejs.core.service.CustomerService;

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
			if (StringUtils.isNotBlank(web.getUserName())) {
				customer.setUserName(web.getUserName());
			}
			customer.setEmail(web.getEmail());
			if (StringUtils.isNotBlank(web.getRole())) {
				customer.setRole(RoleEnum.valueOf(web.getRole()));
			}
			if (StringUtils.isNotBlank(web.getGender())) {
				customer.setGender(GenderEnum.valueOf(web.getGender()));
			}
			if (StringUtils.isNotBlank(web.getPassword())) {
				customer.setPassword(web.getPassword());
			}
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
		web.setRole(customer.getRole().name());
		web.setGender(customer.getGender().name());
		return web;
	}
}
