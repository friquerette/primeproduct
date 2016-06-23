package com.friquerette.primejs.core.dao;

import java.util.List;
import java.util.Map;

import com.friquerette.primejs.core.entity.Customer;

public interface CustomerDao extends IDao<Customer> {

	public static final String FILTER_USERNAME = "username";

	public Customer findByLogin(String login);

	@Deprecated
	List<Customer> findByFilter(Map<String, String> filters);

}
