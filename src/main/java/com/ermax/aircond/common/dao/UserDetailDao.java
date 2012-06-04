package com.ermax.aircond.common.dao;

import com.ermax.aircond.common.domain.UserDetail;
import com.ermax.aircond.util.dao.AbstractHibernateDao;

public interface UserDetailDao extends AbstractHibernateDao<UserDetail> {
	
	public UserDetail findAcUserByUsername(String username);
}
