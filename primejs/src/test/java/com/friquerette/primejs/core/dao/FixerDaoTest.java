package com.friquerette.primejs.core.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.friquerette.primejs.core.boundary.entity.CurrencyEnum;
import com.friquerette.primejs.core.boundary.service.FixerService;
import com.friquerette.primejs.AbstractTest;

/**
 * Some test for the DAO layer of Fixer. Fixer should be mock...
 * 
 * @author Rick
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class FixerDaoTest extends AbstractTest {

	@Autowired
	private FixerService fixerService;

	@Test
	public void testReadExchangeRate() {
		Double exchangeRate = fixerService.getExchangeRate(CurrencyEnum.EUR, CurrencyEnum.GBP);
		assertTrue(exchangeRate > 0 && exchangeRate < 5);
	}

}
