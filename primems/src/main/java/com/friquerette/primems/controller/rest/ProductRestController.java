package com.friquerette.primems.controller.rest;

import static com.friquerette.primems.controller.rest.RestConstant.ALL;
import static com.friquerette.primems.controller.rest.RestConstant.PRODUCT;
import static com.friquerette.primems.controller.rest.RestConstant.PRODUCT_PRIVATE;
import static com.friquerette.primems.controller.rest.RestConstant.PRODUCT_PUBLIC;
import static com.friquerette.primems.controller.rest.RestConstant.ROOT_WS;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.friquerette.primems.core.entity.Product;
import com.friquerette.primems.core.service.ProductService;

@RestController
@RequestMapping(ROOT_WS + PRODUCT)
public class ProductRestController {

	private static final Logger logger = LoggerFactory.getLogger(ProductRestController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = PRODUCT_PUBLIC
			+ ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getPublicProduct() {
		List<Product> products = null;
		try {
			products = productService.findAll();
		} catch (Exception e) {
			logger.error("Failed to read all the public product", e);
		}

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = PRODUCT_PRIVATE
			+ ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getPrivateProduct() {
		List<Product> products = null;
		try {
			products = productService.findForCurrentUser();
		} catch (Exception e) {
			logger.error("Failed to read all the private product", e);
		}

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
