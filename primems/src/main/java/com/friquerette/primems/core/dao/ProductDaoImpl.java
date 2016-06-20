package com.friquerette.primems.core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.friquerette.primems.core.entity.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Product>implements ProductDao {

	@Override
	public Long create(Product product) {
		return persistEntity(product);
	}

	@Override
	public void update(Product product) {
		updateEntity(product);
	}

	@Override
	public Product findById(Long id) {
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("id", id));
		return (Product) criteria.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		Criteria criteria = getSession().createCriteria(Product.class);
		return (List<Product>) criteria.list();
	}

	@Override
	public void delete(Product product) {
		super.deleteEntity(product);
	}

}
