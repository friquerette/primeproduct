package com.friquerette.primems.core.service;

import java.util.List;

import com.friquerette.primems.core.entity.Customer;

public interface CustomerService {

	public List<Customer> findAllCustomers();

	public void deleteCustomerById(Long id);

	public Customer findById(Long id);

	public void updateCustomer(Customer customer);

	public Long createCustomer(Customer customer);

	public Customer getInstance();
}
