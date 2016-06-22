package com.friquerette.primems.controller.rest;

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

import com.friquerette.primems.core.entity.Category;
import com.friquerette.primems.core.service.CategoryService;

@RestController
@RequestMapping(RestConstant.ROOT_WS + RestConstant.CATEGORY)
public class CategoryRestController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryRestController.class);

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = RestConstant.ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getCategoryAll() {
		List<Category> categories = null;
		try {
			categories = categoryService.findAll();
		} catch (Exception e) {
			logger.error("Failed to read all the categories", e);
		}
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}

	@RequestMapping(value = RestConstant.BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
		Category category = null;
		try {
			category = categoryService.findById(id);
		} catch (Exception e) {
			logger.error("Failed to read category for the id " + id, e);
		}
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

	@RequestMapping(value = RestConstant.NEW, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> create(@RequestBody Category category) {
		try {
			Long id = categoryService.create(category);
			category = categoryService.findById(id);
		} catch (Exception e) {
			logger.error("Failed to create the category", e);
			new ResponseEntity<Category>(category, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

}