package com.friquerette.primems.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.friquerette.primems.entity.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
@ContextConfiguration(classes = HibernateConfigurationTest.class)
// @TestPropertySource("classpath:test.properties")
@ComponentScan(basePackages = { "com.friquerette.primems.service", //
		"com.friquerette.primems.dao", //
		"com.friquerette.primems.entity" })
@TestPropertySource(properties = "assets.file=classpath:test.properties")
@Transactional
public class SimpleDaoTest {

	@Autowired
	private CustomerDao customerDao;

	@Test
	public void testGetCustomerById() {
		Customer customer = customerDao.findById(1L);

		assertNotNull(customer);
	}

	@Test
	public void testCreateUser() {
		Customer customer = new Customer();
		customer.setActive(true);
		customer.setFirstName("Toto");
		customer.setLastName("Martin");
		customer.setLogin("Martin");
		customer.setEmail("test@yopmail.com");
		customer.setPassword("pwd");
		customerDao.create(customer);
		assertNotNull(customer.getId());
	}

}
