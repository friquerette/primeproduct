package com.friquerette.primems.core.boundary.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friquerette.primems.core.boundary.dao.FixerDao;
import com.friquerette.primems.core.boundary.entity.CurrencyEnum;
import com.friquerette.primems.core.boundary.entity.Fixer;

@Service("fixerService")
public class FixerServiceImpl implements FixerService {

	private static List<CurrencyEnum> currencies = null;
	@Autowired
	private FixerDao fixerDao;

	private static final Logger logger = LoggerFactory.getLogger(FixerServiceImpl.class);

	@Override
	public Double getExchangeRate(CurrencyEnum from, CurrencyEnum to) {
		try {
			Fixer fixer = fixerDao.latest(from, to);
			return fixer.getRates().get(to);
		} catch (Exception e) {
			String msg = "Failed to read the exchange rate";
			logger.error(msg, e);
			throw new BoundaryServiceException(msg, e);
		}
	}

	/**
	 * Return a list of currencies from the Enum. Maybe get it from Fixer.io
	 * later...
	 * 
	 * Design pattern singleton
	 */
	@Override
	public List<CurrencyEnum> getAllCurrencies() {
		if (currencies == null) {
			currencies = Arrays.asList(CurrencyEnum.values());
		}
		return currencies;
	}

}
