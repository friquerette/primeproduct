package com.friquerette.primems.controller.web.converterweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.friquerette.primems.controller.web.webmodel.ProductWeb;
import com.friquerette.primems.core.entity.Product;
import com.friquerette.primems.core.service.CategoryService;
import com.friquerette.primems.core.service.ProductService;

/**
 * A converter Entity Model/Web Model for the Product
 * 
 * This converter avoid lazy exception... and allow to determined which field
 * could be update
 */
@Component
public class ProductConverter implements WebModelConverter<Product, ProductWeb> {

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
			if (web.getCategoryId() != null) {
				product.setCategory(categoryService.findById(web.getCategoryId()));
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
