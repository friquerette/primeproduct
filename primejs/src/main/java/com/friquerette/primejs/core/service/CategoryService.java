package com.friquerette.primejs.core.service;

import java.util.List;

import com.friquerette.primejs.core.entity.Category;

public interface CategoryService extends IService<Category> {

	public List<Category> getAllActiveCategoryForSelect();

	public void updateFromCopy(Category cc);
}
