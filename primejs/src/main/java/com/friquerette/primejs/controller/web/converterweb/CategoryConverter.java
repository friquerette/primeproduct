package com.friquerette.primejs.controller.web.converterweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.friquerette.primejs.controller.web.webmodel.CategoryWeb;
import com.friquerette.primejs.core.entity.Category;
import com.friquerette.primejs.core.service.CategoryService;

/**
 * A converter Entity Model/Web Model for the Category
 * 
 * This converter avoid lazy exception... and allow to determined which field
 * could be update
 */
@Component
public class CategoryConverter implements WebModelConverter<Category, CategoryWeb> {

	@Autowired(required = true)
	private CategoryService categoryService;

	public Category fromWeb(CategoryWeb web) {
		Category category = null;
		if (web != null) {
			if (web.getId() == null) {
				category = categoryService.getInstance();
			} else {
				category = categoryService.findById(web.getId());
			}
			category.setId(web.getId());
			category.setName(web.getName());
			category.setDescription(web.getDescription());
			if (web.getParentId() != null) {
				category.setParent(categoryService.findById(web.getParentId()));
			}
		}
		return category;
	}

	public CategoryWeb toWeb(Category category) {
		if (category == null) {
			category = categoryService.getInstance();
		}
		CategoryWeb web = new CategoryWeb();
		web.setId(category.getId());
		web.setName(category.getName());
		web.setDescription(category.getDescription());
		/**
		 * TODO later : See how to map select box with an object...
		 */
		if (category.getParent() != null) {
			web.setParentId(category.getParent().getId());
			web.setParentLabel(category.getParent().getLabel());
		}
		return web;
	}
}
