package com.friquerette.primems.core.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.friquerette.primems.core.dao.ProductDao;
import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.entity.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductDao dao;
	@Autowired
	private CustomerService customerService;

	@Override
	@Transactional
	public List<Product> findAll() {
		try {
			List<Product> products = dao.findAll();
			initializeCategory(products);
			return products;
		} catch (Exception e) {
			String message = "Failed to all the product";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	@Override
	@Transactional
	public List<Product> findForCurrentUser() {
		try {
			Customer customer = customerService.getCurrentCustomerFromContext();
			List<Product> products = dao.findByCustomer(customer);
			initializeCategory(products);
			return products;
		} catch (Exception e) {
			String message = "Failed to all the customer's product";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	private void initializeCategory(List<Product> products) {
		for (Product product : products) {
			Hibernate.initialize(product.getCategory());
		}
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		try {
			Product product = findById(id);
			if (product != null) {
				dao.delete(product);
			} else {
				logger.error("Product not found for id " + id);
			}
		} catch (Exception e) {
			String message = "Failed to update the product";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	@Override
	@Transactional
	public Product findById(Long id) {
		Product product = dao.findById(id);
		// Force to load the data
		Hibernate.initialize(product.getCategory());
		Hibernate.initialize(product.getOwner());
		Hibernate.initialize(product.getDescription());
		return product;
	}

	@Override
	@Transactional
	public void update(Product product) {
		try {
			dao.update(product);
		} catch (Exception e) {
			String message = "Failed to update the product";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	@Override
	@Transactional
	public Long create(Product product) {
		try {
			return dao.create(product);
		} catch (Exception e) {
			String message = "Failed to create the product";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	@Override
	@Transactional
	public Product getInstance() {
		Product product = new Product();
		Customer currentCustomer = customerService.getCurrentCustomerFromContext();
		product.setCreatedBy(currentCustomer);
		product.setLastModifiedBy(currentCustomer);
		product.setOwner(currentCustomer);
		product.setEnabled(true);
		return product;
	}

}
