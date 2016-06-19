package com.friquerette.primems.core.dao;

import java.util.List;

import com.friquerette.primems.core.entity.Category;

public interface CategoryDao {

	public Long create(Category category);

	public void update(Category category);

	public Category findById(Long id);

	public List<Category> findAll();

	public void delete(Category category);

}
