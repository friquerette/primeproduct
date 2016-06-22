package com.friquerette.primems.core.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.friquerette.primems.core.dao.CategoryDao;
import com.friquerette.primems.core.entity.Category;
import com.friquerette.primems.core.entity.Customer;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryDao dao;
	@Autowired
	private CustomerService customerService;

	@Override
	@Transactional
	public List<Category> findAll() {
		try {
			return dao.findAll();
		} catch (Exception e) {
			String message = "Failed to read all the category";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	@Override
	@Transactional
	public List<Category> getAllActiveCategoryForSelect() {
		try {
			return dao.findAllActive();
		} catch (Exception e) {
			String message = "Failed to read all the category";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		try {
			Category category = findById(id);
			if (category == null) {
				logger.error("Category not found for id " + id);
			} else if (category.getParent() == null) {
				logger.error("Your're not allow to delete a top parent category " + id);
				throw new PrimemsServiceException("Your're not allow to delete a top parent category ");
			} else {
				dao.delete(category);
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
		try {
			Category category = dao.findById(id);
			if (category != null) {
				// Force to load the data
				Hibernate.initialize(category.getParent());
			}
			return category;
		} catch (Exception e) {
			String message = "Failed to read the category " + id;
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);

		}
	}

	@Override
	@Transactional
	public void update(Category category) {
		try {
			dao.update(category);
		} catch (Exception e) {
			String message = "Failed to update the category";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	@Override
	@Transactional
	public Long create(Category category) {
		try {
			category.setEnabled(true);
			Customer currentCustomer = customerService.getCurrentCustomerFromContext();
			category.setCreatedBy(currentCustomer);
			category.setLastModifiedBy(currentCustomer);
			return dao.create(category);
		} catch (Exception e) {
			String message = "Failed to create the category";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	/**
	 * Design pattern Factory
	 * 
	 * @return
	 */
	@Override
	public Category getInstance() {
		Category category = new Category();
		return category;
	}

}
