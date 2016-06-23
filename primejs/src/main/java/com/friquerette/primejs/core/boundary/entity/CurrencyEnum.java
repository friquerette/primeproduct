package com.friquerette.primejs.core.boundary.entity;

import com.friquerette.primejs.core.entity.IPrimejsEnum;

/**
 * The currency enum. The interface is not in the good package ... Move it in a
 * abstract package later
 * 
 * @author rick
 *
 */
public enum CurrencyEnum implements IPrimejsEnum {
	AUD(1, "Australian Dollar"), //
	BGN(2, "Bulgarian Lev"), //
	BRL(3, "Brazilian Real"), //
	CAD(4, "Canadian Dollar"), //
	CHF(5, "Swiss Franc"), //
	CNY(6, "Renminbi (Yuan)"), //
	CZK(7, "Czech Koruna"), //
	DKK(8, "Danish Krone"), //
	EUR(9, "Euro"), //
	GBP(10, "Pound Sterling"), //
	HKD(11, "Hong Kong Dollar"), //
	HRK(12, "Croatian Kuna"), //
	HUF(13, "Hungary Forint"), //
	IDR(14, "Rupiah"), //
	ILS(15, "New Israeli Sheqel"), //
	INR(16, "Bhutan Ngultrum Indian Rupee"), //
	JPY(17, "Yen"), //
	KRW(18, "Won"), //
	MXN(19, "Mexican Peso"), //
	MYR(20, "Malaysian Ringgit"), //
	NOK(21, "Norwegian Krone"), //
	NZD(22, "New Zealand Dollar"), //
	PHP(23, "Philippine Peso"), //
	PLN(24, "Zloty"), //
	RON(25, "RON"), //
	RUB(26, "Russian Ruble"), //
	SEK(27, "Swedish Krona"), //
	SGD(28, "Singapore Dollar"), //
	THB(29, "Thai Baht"), //
	TRY(30, "Yeni Türk Liras"), //
	USD(31, "United States dollar"), //
	ZAR(32, "ZAR");

	private int order;
	private String label;

	private CurrencyEnum(int order, String label) {
		this.order = order;
		this.label = label;
	}

	public int getOrder() {
		return order;
	}

	public String getLabel() {
		return label;
	}

	public String getValues() {
		return this.name();
	}
}
