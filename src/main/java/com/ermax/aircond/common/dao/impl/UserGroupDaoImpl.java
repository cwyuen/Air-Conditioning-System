package com.ermax.aircond.common.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.ermax.aircond.common.dao.UserGroupDao;
import com.ermax.aircond.common.domain.UserGroup;
import com.ermax.aircond.util.dao.AbstractHibernateDaoImpl;

@Repository("userGroupDao")
public class UserGroupDaoImpl extends AbstractHibernateDaoImpl<UserGroup> implements UserGroupDao, Serializable{
	
	private static final long serialVersionUID = 1L;

	public UserGroupDaoImpl(){
		setClazz(UserGroup.class);
	}
	
	
}
