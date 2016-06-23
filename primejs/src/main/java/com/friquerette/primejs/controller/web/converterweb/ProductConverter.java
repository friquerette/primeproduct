package com.friquerette.primejs.controller.web.converterweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.friquerette.primejs.controller.web.webmodel.ProductWeb;
import com.friquerette.primejs.core.boundary.entity.CurrencyEnum;
import com.friquerette.primejs.core.entity.Product;
import com.friquerette.primejs.core.service.CategoryService;
import com.friquerette.primejs.core.service.ProductService;

/**
 * A converter Entity Model/Web Model for the Product
 * 
 * This converter avoid lazy exception... and allow to determined which field
 * could be update
 */
@Component
public class ProductConverter implements WebModelConverter<Product, ProductWeb> {

	private static final Logger logger = LoggerFactory.getLogger(ProductConverter.class);

	@Autowired(required = true)
	private CategoryService categoryService;

	@Autowired(required = true)
	private ProductService productService;

	public Product fromWeb(ProductWeb web) {
		Product product = null;
		if (web != null) {
			if (web.getId() == null) {
				product = productService.getInstance();
			} else {
				product = productService.findById(web.getId());
			}
			product.setId(web.getId());
			product.setTitle(web.getTitle());
			product.setDescription(web.getDescription());
			product.setPrice(web.getPrice());
			if (web.getCategoryId() != null && web.getCategoryId() != 0) {
				product.setCategory(categoryService.findById(web.getCategoryId()));
			}
			if (web.getCurrency() != null) {
				try {
					product.setCurrency(CurrencyEnum.valueOf(web.getCurrency()));
				} catch (Exception e) {
					logger.error("Failed to read the currency", e);
				}
			}
		}

		return product;
	}

	public ProductWeb toWeb(Product product) {
		if (product == null) {
			product = productService.getInstance();
		}
		ProductWeb web = new ProductWeb();
		web.setId(product.getId());
		web.setTitle(product.getTitle());
		web.setPrice(product.getPrice());
		web.setDescription(product.getDescription());
		/**
		 * TODO later : See how to map select box with an object...
		 */
		if (product.getCategory() != null) {
			web.setCategoryId(product.getCategory().getId());
			web.setCategoryLabel(product.getCategory().getLabel());
		}
		return web;
	}
}
