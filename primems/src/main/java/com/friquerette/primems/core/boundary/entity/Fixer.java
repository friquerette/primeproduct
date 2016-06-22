package com.friquerette.primems.core.boundary.entity;

import java.util.Map;

public class Fixer {

	private String base;

	private String date;

	Map<CurrencyEnum, Double> rates;

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Map<CurrencyEnum, Double> getRates() {
		return rates;
	}

	public void setRates(Map<CurrencyEnum, Double> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "Fixer [base=" + base + ", date=" + date + ", rates=" + rates + "]";
	}

}
