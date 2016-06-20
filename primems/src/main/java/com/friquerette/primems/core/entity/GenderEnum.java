package com.friquerette.primems.core.entity;

import java.util.Arrays;
import java.util.List;

/**
 * The gender of a customer
 * 
 * @author Rick
 *
 */
public enum GenderEnum {
	MALE("Male"), //
	FEMALE("Female");

	private String label;

	private GenderEnum(String label) {
		this.label = label;
	}

	public static List<GenderEnum> getAllGenders() {
		return Arrays.asList(GenderEnum.values());
	}

	public String getLabel() {
		return label;
	}
}
