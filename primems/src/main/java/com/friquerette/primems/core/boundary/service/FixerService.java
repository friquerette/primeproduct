package com.friquerette.primems.core.boundary.service;

import com.friquerette.primems.core.boundary.entity.CurrencyEnum;

public interface FixerService {

	public Double getExchangeRate(CurrencyEnum from, CurrencyEnum to);

}
