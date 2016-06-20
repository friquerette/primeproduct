package com.friquerette.primems.core.service;

import java.util.List;

import com.friquerette.primems.core.entity.Category;

public interface CategoryService {

	public List<Category> findAllCategories();

	public void deleteCategoryById(Long id);

	public Category findById(Long id);

	public void updateCategory(Category category);

	public Category getNewInstance();
}
