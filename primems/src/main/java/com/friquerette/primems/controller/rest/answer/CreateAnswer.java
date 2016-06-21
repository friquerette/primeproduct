package com.friquerette.primems.controller.rest.answer;

import com.friquerette.primems.core.entity.AbstractEntity;

public class CreateAnswer {
	private Long id;
	private String message;
	private AbstractEntity entity;
	private String error;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AbstractEntity getEntity() {
		return entity;
	}

	public void setEntity(AbstractEntity entity) {
		this.entity = entity;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
