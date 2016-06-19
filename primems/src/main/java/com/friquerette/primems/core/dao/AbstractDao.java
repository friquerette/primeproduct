package com.friquerette.primems.core.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.friquerette.primems.core.entity.AbstractEntity;

@Transactional
public abstract class AbstractDao<T extends AbstractEntity> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected Long persistEntity(T entity) {
		entity.setCreateDate(new Date());
		entity.setUpdateDate(new Date());
		getSession().persist(entity);
		return entity.getId();
	}

	protected void deleteEntity(T entity) {
		getSession().delete(entity);
	}

	protected void updateEntity(T entity) {
		entity.setUpdateDate(new Date());
		getSession().update(entity);
	}

}
