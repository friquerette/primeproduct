package com.friquerette.primejs.core.dao;

import java.util.List;

import com.friquerette.primejs.core.entity.Customer;
import com.friquerette.primejs.core.entity.Product;

public interface ProductDao extends IDao<Product> {

	public List<Product> findByCustomer(Customer customer);
}
