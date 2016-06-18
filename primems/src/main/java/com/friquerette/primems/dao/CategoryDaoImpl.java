package com.friquerette.primems.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.friquerette.primems.entity.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Category>implements CategoryDao {

	@Override
	public void create(Category category) {
		persistEntity(category);
	}

	@Override
	public void update(Category category) {
		updateEntity(category);
	}

	@Override
	public Category findById(Long id) {
		Criteria criteria = getSession().createCriteria(Category.class);
		criteria.add(Restrictions.eq("id", id));
		return (Category) criteria.uniqueResult();

	}

	@Override
	public List<Category> findAll() {
		Criteria criteria = getSession().createCriteria(Category.class);
		return (List<Category>) criteria.list();
	}

	@Override
	public void delete(Category category) {
		super.deleteEntity(category);
	}

}
