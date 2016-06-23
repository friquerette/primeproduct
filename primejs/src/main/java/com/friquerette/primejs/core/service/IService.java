package com.friquerette.primejs.core.service;

import java.util.List;

import com.friquerette.primejs.core.entity.AbstractEntity;

public interface IService<T extends AbstractEntity> {

	public List<T> findAll();

	public void deleteById(Long id);

	public T findById(Long id);

	public void update(T entity);

	public Long create(T entity);

	public T getInstance();
}
