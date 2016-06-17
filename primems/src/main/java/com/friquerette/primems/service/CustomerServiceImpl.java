package com.friquerette.primems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.friquerette.primems.dao.CustomerDao;
import com.friquerette.primems.entity.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;

	@Override
	@Transactional
	public List<Customer> findAllCustomers() {
		return dao.findAll();
	}

	@Override
	public void deleteCustomerById(Long id) {
		dao.delete(findById(id));

	}

	@Override
	public Customer findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		dao.update(customer);
	}

}
