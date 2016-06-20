package com.friquerette.primems.controller.web.converterweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.friquerette.primems.controller.web.PrimemsWebException;
import com.friquerette.primems.controller.web.webmodel.CategoryWeb;
import com.friquerette.primems.core.entity.Category;
import com.friquerette.primems.core.service.CategoryService;

/**
 * A converter Entity Model/Web Model for the Category
 * 
 * This converter avoid lazy exception... and allow to determined which field
 * could be update
 */
@Component
public class CategoryConverter implements WebModelConverter<Category, CategoryWeb> {

	@Autowired(required = true)
	@Qualifier(value = "categoryService")
	private CategoryService categoryService;

	public Category fromWeb(CategoryWeb web) {
		Category category;
		if (web == null) {
			throw new PrimemsWebException("The web model is null");
		}
		if (web.getId() == null) {
			category = categoryService.getInstance();
		} else {
			category = categoryService.findById(web.getId());
		}
		category.setId(web.getId());
		category.setName(web.getName());
		category.setDescription(web.getDescription());
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
		return web;
	}
}
