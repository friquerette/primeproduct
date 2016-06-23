package com.friquerette.primejs.core.boundary.service;

import java.util.List;

import com.friquerette.primejs.core.boundary.entity.CurrencyEnum;

public interface FixerService {

	public Double getExchangeRate(CurrencyEnum from, CurrencyEnum to);

	public List<CurrencyEnum> getAllCurrencies();

}
