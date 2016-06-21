package com.friquerette.primems.core.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The gender of a customer
 * 
 * @author Rick
 *
 */
public enum GenderEnum implements IPrimemsEnum {
	MALE("Male"), //
	FEMALE("Female");

	private String label;

	private GenderEnum(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}

	public static List<GenderEnum> getAllAsList() {
		return Arrays.asList(GenderEnum.values());
	}

	public static Map<String, String> getAllAsMap() {
		Map<String, String> genderMap = new HashMap<>();
		for (GenderEnum gender : GenderEnum.values()) {
			genderMap.put(gender.name(), gender.getLabel());
		}
		return genderMap;
	}

}
