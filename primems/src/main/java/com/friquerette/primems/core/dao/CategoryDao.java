package com.friquerette.primems.core.dao;

import java.util.List;

import com.friquerette.primems.core.entity.Category;

public interface CategoryDao extends IDao<Category> {

	public List<Category> findAllActive();
}
