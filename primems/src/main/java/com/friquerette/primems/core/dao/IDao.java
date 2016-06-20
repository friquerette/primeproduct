package com.friquerette.primems.core.dao;

import java.util.List;

import com.friquerette.primems.core.entity.AbstractEntity;

public interface IDao<T extends AbstractEntity> {

	public Long create(T entity);

	public void update(T entity);

	public T findById(Long id);

	public List<T> findAll();

	public void delete(T entity);

}
