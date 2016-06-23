package com.friquerette.primejs.core.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.friquerette.primejs.core.boundary.dao.FixerDao;
import com.friquerette.primejs.core.boundary.entity.CurrencyEnum;
import com.friquerette.primejs.core.boundary.entity.Fixer;
import com.friquerette.primejs.AbstractTest;

/**
 * Some test for the DAO layer of Fixer. Fixer should be mock...
 * 
 * @author Rick
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class FixerServiceTest extends AbstractTest {

	@Autowired
	private FixerDao fixerDao;

	@Test
	public void testReadAll() {
		Fixer fixer = fixerDao.latest();
		assertTrue(fixer.getBase().equals(CurrencyEnum.EUR.name()));
	}

	@Test
	public void testReadSomeCurrency() {
		Fixer fixer = fixerDao.latest(CurrencyEnum.USD, CurrencyEnum.GBP, CurrencyEnum.JPY, CurrencyEnum.PLN);
		assertTrue(fixer.getBase().equals(CurrencyEnum.USD.name()));
		assertTrue(fixer.getRates().size() == 3);
		assertTrue(fixer.getRates().get(CurrencyEnum.GBP) > 0);
		assertTrue(fixer.getRates().get(CurrencyEnum.JPY) > 0);
		assertTrue(fixer.getRates().get(CurrencyEnum.PLN) > 0);
		assertTrue(fixer.getRates().get("EUR") == null);
	}
}
