package com.friquerette.primems.controller.web.webmodel;

public class ProductWeb extends AbstractWebModel {

	private Long id;

	private String title;

	private String description;

	private Double price;

	private CustomerWeb owner;

	private CategoryWeb category;

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

	public CategoryWeb getCategory() {
		return category;
	}

	public void setCategory(CategoryWeb category) {
		this.category = category;
	}

}
