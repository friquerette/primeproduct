package com.friquerette.primejs.core.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.friquerette.primejs.core.boundary.entity.CurrencyEnum;
import com.friquerette.primejs.core.boundary.entity.Fixer;
import com.friquerette.primejs.core.boundary.entity.FixerConst;
import com.friquerette.primejs.core.boundary.entity.FixerUtil;

import junit.framework.TestCase;

public class ClientRestWebTest extends TestCase {
	private static final Logger logger = LoggerFactory.getLogger(ClientRestWebTest.class);

	/**
	 * This case test the reading of the web service for a simple
	 * HttpURLConnection (with a proxy if define...)
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReadUrl() throws Exception {
		String line = "";
		URL url = new URL(FixerConst.URL_LATEST);
		Proxy proxy = FixerUtil.getProxy();
		HttpURLConnection uc;
		if (proxy == null) {
			uc = (HttpURLConnection) url.openConnection();
		} else {
			uc = (HttpURLConnection) url.openConnection(proxy);
		}

		uc.connect();

		String page = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		while ((line = in.readLine()) != null) {
			page += line + "\n";
		}
		assertTrue(page.contains("EUR"));

	}

	/**
	 * A simple Spring Rest Client to read the webservice
	 */
	@Test
	public void testWithRestTemplate() {
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		clientHttpRequestFactory.setProxy(FixerUtil.getProxy());

		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		Fixer response = restTemplate.getForObject(FixerConst.URL_LATEST, Fixer.class);
		logger.info("" + response);
		assertTrue(response.getRates().get(CurrencyEnum.GBP) < 2);

	}

}
