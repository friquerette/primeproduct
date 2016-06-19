package com.friquerette.primems.core.dao;

import java.util.List;

import com.friquerette.primems.core.entity.Customer;

public interface CustomerDao {

	public Long create(Customer customer);

	public void update(Customer customer);

	public Customer findById(Long id);

	public List<Customer> findAll();

	public void delete(Customer customer);

}
