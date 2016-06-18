package com.friquerette.primems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friquerette.primems.dao.CategoryDao;
import com.friquerette.primems.entity.Category;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;

	@Override
	public List<Category> findAllCategorys() {
		return dao.findAll();
	}

	@Override
	public void deleteCategoryById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub

	}

}
