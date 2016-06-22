package com.friquerette.primems.core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.friquerette.primems.core.entity.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Category>implements CategoryDao {

	@Override
	public Long create(Category category) {
		return persistEntity(category);
	}

	@Override
	public void update(Category category) {
		updateEntity(category);
	}

	@Override
	public Category findById(Long id) {
		Criteria criteria = getSession().createCriteria(Category.class, "category");
		criteria.add(Restrictions.eq("id", id));
		criteria.setFetchMode("employee.address", FetchMode.JOIN);
		return (Category) criteria.uniqueResult();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> findAll() {
		Criteria criteria = getSession().createCriteria(Category.class);
		return (List<Category>) criteria.list();
	}

	@Override
	public void delete(Category category) {
		super.deleteEntity(category);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllActive() {
		Criteria criteria = getSession().createCriteria(Category.class);
		criteria.add(Restrictions.eq("enabled", true));
		return (List<Category>) criteria.list();

	}

}
