package com.friquerette.primems;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.friquerette.primems.config.HibernateConfigurationTest;

import junit.framework.TestCase;

@TransactionConfiguration(defaultRollback = true)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
@ContextConfiguration(classes = HibernateConfigurationTest.class)
// @TestPropertySource("classpath:test.properties")
@ComponentScan(basePackages = { "com.friquerette.primems.service", //
		"com.friquerette.primems.dao", //
		"com.friquerette.primems.entity" })
// @TestPropertySource(properties = "assets.file=classpath:test.properties")
public abstract class AbstractTest extends TestCase {

	@SuppressWarnings("unused")
	private Date startDate = null;

	@Before
	public void executedBeforeEach() {
		startDate = new Date();
	}

	@After
	public void executedAfterEach() {
		// TODO : clean data properly (not throw SQL Script...)
	}
}
