package com.ermax.aircond.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ermax.aircond.common.dao.UserDetailDao;
import com.ermax.aircond.common.domain.UserDetail;

@Repository("userDetailDao")
public class UserDetailDaoImpl implements UserDetailDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public UserDetail findAcUserByUsername(String username) {
		
		List<UserDetail> list = sessionFactory.getCurrentSession().createQuery("FROM UserDetail u WHERE u.username = ?").setParameter(0, username).list();

		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}

}
