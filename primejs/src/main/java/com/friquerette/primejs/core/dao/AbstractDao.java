package com.friquerette.primejs.core.dao;

import java.util.Date;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.friquerette.primejs.core.entity.AbstractEntity;

@Transactional
public abstract class AbstractDao<T extends AbstractEntity> {

	private HibernateTemplate hibernateTemplate = null;

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected Long persistEntity(T entity) {
		entity.setCreateDate(new Date());
		entity.setUpdateDate(new Date());
		// getHibernateTemplate().persist(entity);
		getSession().persist(entity);
		return entity.getId();
	}

	protected void deleteEntity(T entity) {
		// getHibernateTemplate().delete(entity);
		getSession().delete(entity);
	}

	protected void updateEntity(T entity) {
		entity.setUpdateDate(new Date());
		// getHibernateTemplate().update(entity);
		getSession().update(entity);
	}

	protected void fillQueryWithParameter(Query query, Map<String, String> parameters) {
		if (!parameters.isEmpty()) {
			for (Map.Entry<String, String> parameter : parameters.entrySet()) {
				query.setParameter(parameter.getKey(), parameter.getValue());
			}
		}
	}

	/**
	 * Some documentation on the HibernateTemplate :
	 * 
	 * @url "http://www.springbyexample.org/examples/simple-hibernate-xml-config-code-example.html"
	 *      To study for later...
	 * @return HibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		if (hibernateTemplate == null) {
			hibernateTemplate = new HibernateTemplate(sessionFactory);
		}
		return hibernateTemplate;
	}
}
