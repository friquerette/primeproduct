package com.friquerette.primems.core.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.friquerette.primems.AbstractTest;
import com.friquerette.primems.core.dao.CustomerDao;
import com.friquerette.primems.core.entity.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerDaoTest extends AbstractTest {

	@Autowired
	private CustomerDao customerDao;

	@Test
	public void testReadCustomerById() {
		// TODO : don't read a specific ID...
		Customer customer = customerDao.findById(1L);
		assertNotNull(customer);
	}

	@Test
	public void testUpdateCustomer() {
		// Create Customer
		Customer customer = getNewCustomer();
		assertEquals("Toto", customer.getFirstName());
		customerDao.create(customer);
		// Update Customer
		customer.setFirstName("Jean2");
		customerDao.update(customer);
		// Read and check
		customer = customerDao.findById(customer.getId());
		assertNotNull(customer);
		assertEquals("Jean2", customer.getFirstName());
	}

	@Test
	public void testCreateCustomer() {
		Customer customer = getNewCustomer();
		customerDao.create(customer);
		assertNotNull(customer.getId());
		customer = customerDao.findById(customer.getId());
		assertEquals("Toto", customer.getFirstName());
	}

	@Test
	public void testDeleteCustomer() {
		Customer customer = getNewCustomer();
		customerDao.create(customer);
		Long id = customer.getId();
		assertNotNull(id);
		customer = customerDao.findById(id);
		assertNotNull(customer);
		customerDao.delete(customer);
		customer = customerDao.findById(id);
		assertNull(customer);
	}

	/**
	 * Return a new customer
	 * 
	 * @return a customer
	 */
	private Customer getNewCustomer() {
		Customer customer = new Customer();
		customer.setActive(true);
		customer.setFirstName("Toto");
		customer.setLastName("Martin");
		customer.setLogin("Martin");
		customer.setEmail("test@yopmail.com");
		customer.setPassword("pwd");
		return customer;
	}

}
