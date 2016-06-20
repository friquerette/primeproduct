package com.friquerette.primems.core.dao;

import java.util.List;

import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.entity.Product;

public interface ProductDao extends IDao<Product> {

	public List<Product> findByCustomer(Customer customer);
}
