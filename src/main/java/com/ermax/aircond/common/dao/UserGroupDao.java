package com.ermax.aircond.common.dao;

import java.util.List;

import com.ermax.aircond.common.domain.UserGroup;
import com.ermax.aircond.util.dao.AbstractHibernateDao;

public interface UserGroupDao extends AbstractHibernateDao<UserGroup>{
	public List<UserGroup> findUserGroupByKeyword(String keyword);
}
