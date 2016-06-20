package com.friquerette.primems.controller.web.converterweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.friquerette.primems.controller.web.PrimemsWebException;
import com.friquerette.primems.controller.web.webmodel.ProductWeb;
import com.friquerette.primems.core.entity.Product;
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
	@Qualifier(value = "productService")
	private ProductService productService;

	public Product fromWeb(ProductWeb web) {
		Product product;
		if (web == null) {
			throw new PrimemsWebException("The web model is null");
		}
		if (web.getId() == null) {
			product = productService.getInstance();
		} else {
			product = productService.findById(web.getId());
		}
		product.setId(web.getId());
		product.setTitle(web.getTitle());
		product.setDescription(web.getDescription());
		return product;
	}

	public ProductWeb toWeb(Product product) {
		if (product == null) {
			product = productService.getInstance();
		}
		ProductWeb web = new ProductWeb();
		web.setId(product.getId());
		web.setTitle(product.getTitle());
		web.setDescription(product.getDescription());
		return web;
	}
}
