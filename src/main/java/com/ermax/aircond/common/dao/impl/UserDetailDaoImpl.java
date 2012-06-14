package com.ermax.aircond.common.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ermax.aircond.common.dao.UserDetailDao;
import com.ermax.aircond.common.domain.UserDetail;
import com.ermax.aircond.util.dao.AbstractHibernateDaoImpl;

@Repository("userDetailDao")
public class UserDetailDaoImpl extends AbstractHibernateDaoImpl<UserDetail> implements UserDetailDao, java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	public UserDetailDaoImpl(){
		setClazz(UserDetail.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public UserDetail findAcUserByUsername(String username) {
		
		List<UserDetail> list = getCurrentSession().createQuery("FROM UserDetail u WHERE u.username = ?")
				.setParameter(0, username).list();

		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}
	

}
