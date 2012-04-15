package com.ermax.aircond.common.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ermax.aircond.common.dao.UserDetailDao;
import com.ermax.aircond.common.domain.UserDetail;

@Repository("userDetailDao")
public class UserDetailDaoImpl implements UserDetailDao,Serializable {		

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	private static List<UserDetail> userDetails;

	@Override
	public List<UserDetail> getUserDetailByUserGroup(String userGroup) {
		List<UserDetail> results = new ArrayList<UserDetail>();
		Iterator<UserDetail> iterator = userDetails.iterator();
		while (iterator.hasNext()) {
			UserDetail userDetail = iterator.next();
			if (userGroup.equals(userDetail.getUserGroup())) {
				results.add(userDetail);
			}
		}
		return results;
	}

	@Override
	public UserDetail getUserDetailById(long id) {
		Iterator<UserDetail> iterator = userDetails.iterator();
		while (iterator.hasNext()) {
			UserDetail userDetail = iterator.next();
			if (id == userDetail.getId()) {
				return userDetail;
			}
		}
		return null;
	}

	@Override
	public void add(UserDetail userDetail) {		
		userDetails.add(userDetail);
	}
	
	@Override
	public UserDetail getUserDetailByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<UserDetail> list = sessionFactory.getCurrentSession().createQuery(		
				"FROM UserDetail ud WHERE ud.username = ?")
				.setParameter(0, username).list();				
		
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
}
