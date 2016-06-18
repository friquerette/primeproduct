package com.friquerette.primems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id", nullable = false)
	private Long id;

	@Column(name = "name", nullable = true)
	private String name;

	@Column(name = "desciption", nullable = true)
	private String desciption;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
