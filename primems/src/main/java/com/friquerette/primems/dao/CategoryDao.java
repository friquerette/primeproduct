package com.friquerette.primems.dao;

import java.util.List;

import com.friquerette.primems.entity.Category;

public interface CategoryDao {

	public void create(Category category);

	public void update(Category category);

	public Category findById(Long id);

	public List<Category> findAll();

	public void delete(Category category);

}
