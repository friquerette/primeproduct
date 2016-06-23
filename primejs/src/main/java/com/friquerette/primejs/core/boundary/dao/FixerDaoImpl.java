package com.friquerette.primejs.core.boundary.dao;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.friquerette.primejs.core.boundary.entity.CurrencyEnum;
import com.friquerette.primejs.core.boundary.entity.Fixer;
import com.friquerette.primejs.core.boundary.entity.FixerConst;
import com.friquerette.primejs.core.boundary.entity.FixerUtil;

@Repository("fixerDao")
public class FixerDaoImpl implements FixerDao {

	private Fixer read(String end_url) {

		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		clientHttpRequestFactory.setProxy(FixerUtil.getProxy());

		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		return restTemplate.getForObject(FixerConst.REST_SERVICE_URI + end_url, Fixer.class);
	}

	@Override
	public Fixer latest() {
		return read(FixerConst.LATEST + CurrencyEnum.EUR.name());
	}

	@Override
	public Fixer latest(CurrencyEnum base, CurrencyEnum... symbols) {
		if (base == null) {
			base = CurrencyEnum.EUR;
		}
		String allSymbols = "&symbols=";
		String separator = "";
		if (symbols != null) {
			for (CurrencyEnum currencyEnum : symbols) {
				allSymbols += currencyEnum.name() + separator;
				separator = ",";
			}
		}
		return read(FixerConst.LATEST + base.name() + allSymbols);
	}
}
