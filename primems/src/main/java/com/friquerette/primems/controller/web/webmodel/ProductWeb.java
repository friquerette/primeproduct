package com.friquerette.primems.controller.web.webmodel;

import com.friquerette.primems.core.boundary.entity.CurrencyEnum;

public class ProductWeb extends AbstractWebModel {

	private Long id;

	private String title;

	private String description;

	private Double price;

	private String currency = CurrencyEnum.EUR.name();

	private CustomerWeb owner;

	private Long categoryId = 0l;
	private String categoryLabel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public CustomerWeb getOwner() {
		return owner;
	}

	public void setOwner(CustomerWeb owner) {
		this.owner = owner;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryLabel() {
		return categoryLabel;
	}

	public void setCategoryLabel(String categoryLabel) {
		this.categoryLabel = categoryLabel;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
