package com.friquerette.primejs.core.dao;

import java.util.List;

import com.friquerette.primejs.core.entity.Category;

public interface CategoryDao extends IDao<Category> {

	public List<Category> findAllActive();
}
