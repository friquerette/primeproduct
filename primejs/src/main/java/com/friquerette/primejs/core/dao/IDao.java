package com.friquerette.primejs.core.dao;

import java.util.List;

import com.friquerette.primejs.core.entity.AbstractEntity;

public interface IDao<T extends AbstractEntity> {

	public Long create(T entity);

	public void update(T entity);

	public T findById(Long id);

	public List<T> findAll();

	public void delete(T entity);

}
