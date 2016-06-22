package com.friquerette.primems.core.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.friquerette.primems.core.boundary.entity.CurrencyEnum;
import com.friquerette.primems.core.boundary.service.FixerService;
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
	@Autowired
	private FixerService fixerService;

	@Override
	@Transactional
	public List<Product> findAll() {
		try {
			List<Product> products = dao.findAll();
			initializeCategories(products);
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
			initializeCategories(products);
			return products;
		} catch (Exception e) {
			String message = "Failed to all the customer's product";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	private void initializeCategories(List<Product> products) {
		for (Product product : products) {
			Hibernate.initialize(product.getCategory());
			Hibernate.initialize(product.getOwner());
			Hibernate.initialize(product.getDescription());
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
		try {
			Product product = dao.findById(id);
			// Force to load the data
			Hibernate.initialize(product.getCategory());
			Hibernate.initialize(product.getOwner());
			Hibernate.initialize(product.getDescription());
			return product;
		} catch (Exception e) {
			String message = "Failed to read the product " + id;
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);

		}
	}

	@Override
	@Transactional
	public void update(Product product) {
		try {
			convertPriceToEuroIfNeed(product);
			product.setLastModifiedBy(getCurrentCustomer());
			dao.update(product);
		} catch (Exception e) {
			String message = "Failed to update the product";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	/**
	 * Received a "carbon copy". Update the product from this. Maybe transformer
	 * this method by a converter like for the APP Web. For this add a layer
	 * converter between Service and Controller Rest
	 */
	@Override
	public void updateFromCopy(Product cc) {
		try {
			if (cc != null) {
				Product product = dao.findById(cc.getId());
				product.setTitle(cc.getTitle());
				product.setDescription(cc.getDescription());
				product.setPrice(cc.getPrice());
				product.setCurrency(cc.getCurrency());
				update(product);
			}
		} catch (Exception e) {
			String message = "Failed to update the category";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	@Override
	@Transactional
	public Long create(Product product) {
		try {
			convertPriceToEuroIfNeed(product);
			Customer currentCustomer = getCurrentCustomer();
			product.setCreatedBy(currentCustomer);
			product.setLastModifiedBy(currentCustomer);
			product.setOwner(currentCustomer);
			return dao.create(product);
		} catch (Exception e) {
			String message = "Failed to create the product";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	/**
	 * Transform the price on the produc to Euro
	 * 
	 * @param product
	 */
	private void convertPriceToEuroIfNeed(Product product) {
		if (product != null && product.getPrice() != null
				&& !CurrencyEnum.EUR.name().equals(product.getCurrency().name())) {
			Double rate = fixerService.getExchangeRate(product.getCurrency(), CurrencyEnum.EUR);
			Double priceEuro = product.getPrice() * rate;
			product.setPrice(priceEuro);
			product.setCurrency(CurrencyEnum.EUR);
		}
	}

	/**
	 * Get the current connect user from the customer service
	 * 
	 * @return
	 */
	private Customer getCurrentCustomer() {
		try {
			return customerService.getCurrentCustomerFromContext();
		} catch (Exception e) {
			String message = "Failed to read the current customer";
			logger.error(message, e);
			throw new PrimemsServiceException(message, e);
		}
	}

	@Override
	@Transactional
	public Product getInstance() {
		Product product = new Product();
		product.setEnabled(true);
		product.setCurrency(CurrencyEnum.EUR);
		return product;
	}

}
