package com.friquerette.primejs.core.boundary.entity;

import java.net.InetSocketAddress;
import java.net.Proxy;

import org.apache.commons.lang3.StringUtils;

/**
 * The const to connect to the web service
 * 
 * @author rick
 *
 */
public class FixerUtil {

	/**
	 * The setting for the proxy. TO Add to a external configuration if use
	 * somewhere else in the application
	 */
	public static String PROXY_URL = "";
	public static int PROXY_PORT = 3131;

	/**
	 * A method util to get the proxy if the setting is present
	 * 
	 * @return
	 */
	public static Proxy getProxy() {
		Proxy proxy = null;
		if (StringUtils.isNotBlank(PROXY_URL)) {
			proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_URL, PROXY_PORT));
		}
		return proxy;
	}
}
