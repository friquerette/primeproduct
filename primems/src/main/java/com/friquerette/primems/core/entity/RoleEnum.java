package com.friquerette.primems.core.entity;

import java.util.Arrays;
import java.util.List;

public enum RoleEnum {
	ROLE_USER("A simple user"), //
	ROLE_ADMIN("A sysadmin user");

	String description;

	private RoleEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static List<RoleEnum> getAllGenders() {
		return Arrays.asList(RoleEnum.values());
	}

}
