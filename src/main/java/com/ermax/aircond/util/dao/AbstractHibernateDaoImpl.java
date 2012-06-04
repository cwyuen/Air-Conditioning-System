package com.ermax.aircond.util.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDaoImpl<T extends Serializable> {

	private Class<T> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	public void setClazz(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@SuppressWarnings("unchecked")
	public T getById(final Long id) {
		return (T) this.getCurrentSession().get(this.clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return this.getCurrentSession().createQuery("from " + this.clazz.getName()).list();
	}

	public void create(final T entity) {
		this.getCurrentSession().persist(entity);
	}

	public void update(final T entity) {
		this.getCurrentSession().merge(entity);
	}

	public void delete(final T entity) {
		this.getCurrentSession().delete(entity);
	}

	public void deleteById(final Long entityId) {
		final T entity = this.getById(entityId);

		this.delete(entity);
	}

	protected Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
}