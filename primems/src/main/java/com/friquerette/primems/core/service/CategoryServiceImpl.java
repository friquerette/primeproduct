package com.friquerette.primems.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.friquerette.primems.core.dao.CategoryDao;
import com.friquerette.primems.core.entity.Category;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryDao dao;

	@Override
	@Transactional
	public List<Category> findAllCategories() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void deleteCategoryById(Long id) {
		try {
			Category category = findById(id);
			if (category != null) {
				dao.delete(category);
			} else {
				logger.error("Category not found for id " + id);
			}
		} catch (Exception e) {
			String message = "Failed to update the category";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}

	}

	@Override
	@Transactional
	public Category findById(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional
	public void updateCategory(Category category) {
		try {
			dao.update(category);
		} catch (Exception e) {
			String message = "Failed to update the category";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	@Override
	public Category getNewInstance() {
		Category category = new Category();
		category.setEnabled(true);
		// category.setRole(RoleEnum.ROLE_USER);
		SecurityContextHolder.getContext().getAuthentication();
		return category;
	}

}
