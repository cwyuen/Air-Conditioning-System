package com.ermax.aircond.common.dao;

import java.util.List;

import com.ermax.aircond.common.domain.UserDetail;
import com.ermax.aircond.util.dao.AbstractHibernateDao;

public interface UserDetailDao extends AbstractHibernateDao<UserDetail> {
	
	public UserDetail findAcUserByUsername(String username);
	public List<UserDetail> findUserDetailByKeyword(String keyword);
}
