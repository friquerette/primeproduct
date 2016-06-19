package com.friquerette.primems.core.entity;

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

}
