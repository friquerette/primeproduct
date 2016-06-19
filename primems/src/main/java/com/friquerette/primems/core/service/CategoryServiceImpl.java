package com.friquerette.primems.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.friquerette.primems.core.dao.CategoryDao;
import com.friquerette.primems.core.entity.Category;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;

	@Override
	@Transactional
	public List<Category> findAllCategories() {
		return dao.findAll();
	}

	@Override
	public void deleteCategoryById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Category findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub

	}

}
