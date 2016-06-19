package com.friquerette.primems.core.entity;

public enum RoleEnum {
	USER("A simple user"), //
	ADMIN("A sysadmin user");

	String description;

	private RoleEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
