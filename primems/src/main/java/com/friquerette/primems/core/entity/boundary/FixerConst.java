package com.friquerette.primems.core.entity.boundary;

/**
 * The const to connect to the web service
 * 
 * @author rick
 *
 */
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

	/**
	 * The setting for the proxy. TO Add to a external configuration if use
	 * somewhere else in the application
	 */
	public static String PROXY_URL = "";
	public static int PROXY_PORT = 3131;

}
