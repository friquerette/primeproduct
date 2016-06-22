package com.friquerette.primems.controller.rest;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.friquerette.primems.core.entity.Product;
import com.friquerette.primems.core.service.ProductService;

/**
 * 
 * @author Rick
 *
 */
@RestController
@RequestMapping(ROOT_WS + PRODUCT)
public class ProductRestController {

	private static final Logger logger = LoggerFactory.getLogger(ProductRestController.class);

	@Autowired
	private ProductService productService;

	/**
	 * Method Get All Product Public
	 * 
	 * @return
	 */
	@RequestMapping(value = PRODUCT_PUBLIC, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getPublicProduct() {
		try {
			List<Product> products = productService.findAll();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Failed to read all the public product", e);
			return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Method Get All Product Private. All the product of the connected user
	 * 
	 * @return
	 */
	@RequestMapping(value = PRODUCT_PRIVATE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getPrivateProductAll() {
		try {
			List<Product> products = productService.findForCurrentUser();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Failed to read all the private product", e);
			return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Method Post to create
	 * 
	 * @param product
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> create(@RequestBody Product product) {
		try {
			Long id = productService.create(product);
			product = productService.findById(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Failed to create the product", e);
			return new ResponseEntity<Product>(product, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Method Put to update
	 * 
	 * @param product
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> update(@RequestBody Product product) {
		try {
			productService.updateFromCopy(product);
			product = productService.findById(product.getId());
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Failed to update the product", e);
			return new ResponseEntity<Product>(product, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Method Delete by id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = RestConstant.BY_ID, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> deleteById(@PathVariable("id") Long id) {
		try {
			productService.deleteById(id);
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("Failed to delete the product for the id " + id, e);
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}