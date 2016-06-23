package com.friquerette.primejs.controller.rest;

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

import com.friquerette.primejs.core.entity.Category;
import com.friquerette.primejs.core.service.CategoryService;

/**
 * The Rest Controller for the connected ROLE_ADMIN
 * 
 * @author Rick
 *
 */
@RestController
@RequestMapping(RestConstant.ROOT_WS + RestConstant.CATEGORY)
public class CategoryRestController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryRestController.class);

	@Autowired
	private CategoryService categoryService;

	/**
	 * Method Get All
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getCategoryAll() {
		try {
			List<Category> categories = categoryService.findAll();
			return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Failed to read all the categories", e);
			return new ResponseEntity<List<Category>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Method Get By Id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = RestConstant.BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
		try {
			Category category = categoryService.findById(id);
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Failed to read category " + id, e);
			return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Method Post to create
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> create(@RequestBody Category category) {
		try {
			Long id = categoryService.create(category);
			category = categoryService.findById(id);
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Failed to create the category", e);
			return new ResponseEntity<Category>(category, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Method Put to update
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> update(@RequestBody Category category) {
		try {
			categoryService.updateFromCopy(category);
			category = categoryService.findById(category.getId());
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Failed to update the category", e);
			return new ResponseEntity<Category>(category, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Method Delete by id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = RestConstant.BY_ID, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> deleteById(@PathVariable("id") Long id) {
		try {
			categoryService.deleteById(id);
			return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("Failed to delete the category for the id " + id, e);
			return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}