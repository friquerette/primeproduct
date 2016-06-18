package com.friquerette.primems.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.friquerette.primems.entity.AbstractEntity;

@Transactional
public abstract class AbstractDao<T extends AbstractEntity> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void persistEntity(T entity) {
		entity.setCreateDate(new Date());
		entity.setUpdateDate(new Date());
		getSession().persist(entity);
	}

	protected void deleteEntity(T entity) {
		getSession().delete(entity);
	}

	protected void updateEntity(T entity) {
		entity.setUpdateDate(new Date());
		getSession().update(entity);
	}

}
