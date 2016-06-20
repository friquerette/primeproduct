package com.friquerette.primems.core.dao;

import java.util.List;
import java.util.Map;

import com.friquerette.primems.core.entity.Customer;

public interface CustomerDao {

	public static final String FILTER_USERNAME = "username";

	public Long create(Customer customer);

	public void update(Customer customer);

	public Customer findById(Long id);

	public Customer findByLogin(String login);

	public List<Customer> findAll();

	public void delete(Customer customer);

	@Deprecated
	List<Customer> findByFilter(Map<String, String> filters);

}
