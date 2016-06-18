package com.friquerette.primems.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.friquerette.primems.entity.Category;
import com.friquerette.primems.service.CategoryService;

@RestController
public class CategoryRestController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryRestController.class);

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/category", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> getUser() {
		Category category = null;
		try {
			List<Category> categories = categoryService.findAllCategories();
			if (categories != null && !categories.isEmpty()) {
				category = categories.get(0);
				logger.info("Category with id " + category.getId());
			}
		} catch (Exception e) {
			logger.error("Failed to read all the categories", e);
		}

		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

	@RequestMapping(value = "/category/{firstname}/{lastname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> createUser(//
			@PathVariable("firstname") String firstname, //
			@PathVariable("lastname") String lastname) {
		logger.info("Fetching Category with id ");
		Category category = new Category();
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
}
