package com.friquerette.primems.core.boundary.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friquerette.primems.core.boundary.dao.FixerDao;
import com.friquerette.primems.core.boundary.entity.CurrencyEnum;
import com.friquerette.primems.core.boundary.entity.Fixer;

@Service("fixerService")
public class FixerServiceImpl implements FixerService {

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
}
