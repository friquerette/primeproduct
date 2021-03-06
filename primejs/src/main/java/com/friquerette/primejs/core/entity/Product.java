package com.friquerette.primejs.core.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.friquerette.primejs.core.boundary.entity.CurrencyEnum;

@Entity
@Table(name = "product")
public class Product extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4955015091636349902L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", nullable = false)
	private Long id;

	@Column(name = "title")
	private String title;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Double price;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "owner")
	@JsonIgnore
	private Customer owner;

	/**
	 * The currency, a transient object. All the product price are in Euro. Will
	 * be persist if the currency change later.
	 */
	@Transient
	private CurrencyEnum currency = CurrencyEnum.EUR;

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

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Transient
	@Override
	public String getLabel() {
		return getTitle();
	}

	public CurrencyEnum getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyEnum currency) {
		this.currency = currency;
	}
}
