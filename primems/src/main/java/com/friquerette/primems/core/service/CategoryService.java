package com.friquerette.primems.core.service;

import java.util.List;

import com.friquerette.primems.core.entity.Category;

public interface CategoryService extends IService<Category> {

	public List<Category> getAllActiveCategoryForSelect();

}
