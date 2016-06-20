package com.friquerette.primems.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.friquerette.primems.core.dao.CustomerDao;
import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.entity.RoleEnum;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerDao dao;

	@Override
	@Transactional
	public List<Customer> findAllCustomers() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void deleteCustomerById(Long id) {
		dao.delete(findById(id));
	}

	@Override
	@Transactional
	public Customer findById(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		try {
			dao.update(customer);
		} catch (Exception e) {
			String message = "Failed to update the customer";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	@Override
	@Transactional
	public Long createCustomer(Customer customer) {
		try {
			return dao.create(customer);
		} catch (Exception e) {
			/**
			 * TODO : Handle in a better the error (different catch... not a
			 * Catch Exception)
			 */
			String message = "Failed to create the user";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	@Override
	public Customer getInstance() {
		Customer customer = new Customer();
		customer.setEnabled(true);
		customer.setRole(RoleEnum.ROLE_USER);
		return customer;
	}

}
