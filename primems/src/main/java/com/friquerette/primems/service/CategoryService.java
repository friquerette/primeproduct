package com.friquerette.primems.service;

import java.util.List;

import com.friquerette.primems.entity.Category;

public interface CategoryService {

	public List<Category> findAllCategories();

	public void deleteCategoryById(Long id);

	public Category findById(Long id);

	public void updateCategory(Category category);

}
