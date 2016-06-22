package com.friquerette.primems.core.service;

import java.util.List;

import com.friquerette.primems.core.entity.Product;

public interface ProductService extends IService<Product> {

	public List<Product> findForCurrentUser();

	public void updateFromCopy(Product product);

}
