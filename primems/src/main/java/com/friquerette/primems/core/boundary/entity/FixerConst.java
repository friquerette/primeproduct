package com.friquerette.primems.core.boundary.entity;

public class FixerConst {
	/**
	 * The base URL of the Webservice Rest
	 * 
	 */
	public static final String REST_SERVICE_URI = "http://api.fixer.io/";

	/**
	 * The entry point to read the last foreign exchange rate
	 * 
	 */
	public static String URL_LATEST = REST_SERVICE_URI + "latest?base=" + CurrencyEnum.USD.name();

	public static String LATEST = "latest?base=";
}
