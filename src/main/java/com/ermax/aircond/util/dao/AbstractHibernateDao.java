package com.ermax.aircond.util.dao;

import java.util.List;

public interface AbstractHibernateDao<T> {
		
	public T getById(final Long id);
	public List<T> findAll();
	public void create(final T entity);	
	public void update(final T entity);
	public void delete(final T entity);
	public void deleteById(final Long entityId);	
}