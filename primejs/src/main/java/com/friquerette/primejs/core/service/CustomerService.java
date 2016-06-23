package com.friquerette.primejs.core.service;

import com.friquerette.primejs.core.entity.Customer;

public interface CustomerService extends IService<Customer> {

	public Customer getCurrentCustomerFromContext();

	public String getAuthenticationUsername();

}
