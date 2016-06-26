package com.friquerette.primejs.controller.rest;

import static com.friquerette.primejs.controller.rest.RestConstant.CURRENCY;
import static com.friquerette.primejs.controller.rest.RestConstant.PUBLIC;
import static com.friquerette.primejs.controller.rest.RestConstant.ROOT_WS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friquerette.primejs.core.boundary.entity.CurrencyEnum;
import com.friquerette.primejs.core.boundary.service.FixerService;

/**
 * 
 * Todo Later : a currency web service...
 * 
 * @author Rick
 *
 */
@RestController
@RequestMapping(ROOT_WS + CURRENCY + PUBLIC)
public class CurrencyRestController {

	@Autowired
	private FixerService fixerService;

	@RequestMapping("/id")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	@RequestMapping("/currenciesList")
	public ResponseEntity<Map<String, String>> getCurrenciesList() {
		List<CurrencyEnum> currencies = fixerService.getAllCurrencies();
		Map<String, String> model = new HashMap<String, String>();
		for (CurrencyEnum currencyEnum : currencies) {
			model.put(currencyEnum.name(), currencyEnum.getLabel());
		}
		return new ResponseEntity<Map<String, String>>(model, HttpStatus.OK);
	}

}
