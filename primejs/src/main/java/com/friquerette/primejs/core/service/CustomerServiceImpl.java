package com.friquerette.primejs.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.friquerette.primejs.core.dao.CustomerDao;
import com.friquerette.primejs.core.entity.Customer;
import com.friquerette.primejs.core.entity.RoleEnum;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerDao dao;

	@Override
	@Transactional
	public List<Customer> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dao.delete(findById(id));
	}

	@Override
	@Transactional
	public Customer findById(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional
	public void update(Customer customer) {
		try {
			dao.update(customer);
		} catch (Exception e) {
			String message = "Failed to update the customer";
			logger.error(message, e);
			throw new PrimejsServiceException(message, e);
		}
	}

	@Override
	@Transactional
	public Long create(Customer customer) {
		try {
			return dao.create(customer);
		} catch (Exception e) {
			/**
			 * TODO : Handle in a better the error (different catch... not a
			 * Catch Exception)
			 */
			String message = "Failed to create the user";
			logger.error(message, e);
			throw new PrimejsServiceException(message, e);
		}
	}

	/**
	 * Design pattern Factory
	 * 
	 * @return
	 */
	@Override
	public Customer getInstance() {
		Customer customer = new Customer();
		customer.setEnabled(true);
		customer.setRole(RoleEnum.ROLE_USER);
		return customer;
	}

	/**
	 * Return the customer from context the unique login that is kept by Spring
	 * Security
	 * 
	 * TODO : to improve later by storing this information in Spring Context
	 * 
	 * @return
	 */
	@Override
	@Transactional
	public Customer getCurrentCustomerFromContext() {
		// Map<String, String> filters = new HashMap<>();
		// filters.put(CustomerDao.FILTER_USERNAME,
		// getAuthenticationUsername());
		// List<Customer> customers = dao.find(filters);
		// Customer customer = null;
		// if (customers != null && customers.size() == 1) {
		// customer = customers.get(0);
		// }
		return dao.findByLogin(getAuthenticationUsername());
	}

	/**
	 * Return the current Authentication user name in the Spring Context
	 * 
	 * @return
	 */
	@Override
	public String getAuthenticationUsername() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
