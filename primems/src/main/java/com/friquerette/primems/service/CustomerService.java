package com.friquerette.primems.service;

import java.util.List;

import com.friquerette.primems.entity.Customer;

public interface CustomerService {

	public List<Customer> findAllCustomers();

	public void deleteCustomerById(Long id);

	public Customer findById(Long id);

	public void updateCustomer(Customer customer);
}
