package com.friquerette.primems.dao;

import java.util.List;

import com.friquerette.primems.entity.Customer;

public interface CustomerDao {

	public void create(Customer customer);

	public void save(Customer customer);

	public void update(Customer customer);

	public Customer findById(Long id);

	public List<Customer> findAll();

	public void delete(Customer customer);

}
