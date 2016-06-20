package com.friquerette.primems.core.service;

import com.friquerette.primems.core.entity.Customer;

public interface CustomerService extends IService<Customer> {

	public Customer getCurrentCustomerFromContext();

	public String getAuthenticationUsername();

}
