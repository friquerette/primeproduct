package com.friquerette.primems.core.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum RoleEnum implements IPrimemsEnum {
	ROLE_USER("User", "A simple user"), //
	ROLE_ADMIN("Admin", "A sysadmin user");

	String label;
	String description;

	private RoleEnum(String label, String description) {
		this.label = label;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String getValues() {
		return this.name();
	}

	public static List<RoleEnum> getAllAsList() {
		return Arrays.asList(RoleEnum.values());
	}

	public static Map<String, String> getAllAsMap() {
		Map<String, String> genderMap = new HashMap<>();
		for (RoleEnum role : RoleEnum.values()) {
			genderMap.put(role.name(), role.getLabel());
		}
		return genderMap;
	}
}
