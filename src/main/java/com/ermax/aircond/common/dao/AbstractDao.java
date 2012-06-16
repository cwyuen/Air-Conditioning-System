/**
 * 
 */
package com.ermax.aircond.common.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Eric
 *
 */
public abstract class AbstractDao implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -4372485078361060458L;

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
