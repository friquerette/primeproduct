package com.friquerette.primems.core.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.friquerette.primems.AbstractTest;
import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.entity.GenderEnum;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest extends AbstractTest {

	@Autowired
	private CustomerService customerService;

	@Test
	public void testCreateCustomer() {
		Customer customer = customerService.getInstance();
		customer.setEnabled(true);
		customer.setFirstName("Toto");
		try {
			customerService.create(customer);
			fail("The user shouldn't be created !!!");
		} catch (PrimemsServiceException e) {
			assertNull(customer.getId());
		}
		customer.setLastName("Martin");
		customer.setUserName("Martin");
		customer.setEmail("test@yopmail.com");
		customer.setPassword("pwd");
		customer.setGender(GenderEnum.MALE);
		customerService.create(customer);
		assertNotNull(customer.getId());

		// TODO : Clean the data (to do on @After)
		customerService.deleteById(customer.getId());
	}
}
