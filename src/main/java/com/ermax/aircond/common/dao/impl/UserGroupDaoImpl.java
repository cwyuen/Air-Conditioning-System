package com.ermax.aircond.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<UserGroup> findUserGroupByKeyword(String keyword) {
		StringBuilder sbSearch = new StringBuilder();
		sbSearch.append("%");
		sbSearch.append(keyword);
		sbSearch.append("%");
		
		Query q = this.getCurrentSession().createQuery("from UserGroup ug where groupName like :name or description like :description");
		q.setParameter("name", sbSearch.toString());
		q.setParameter("description", sbSearch.toString());
		
		return q.list();
		
	}
	
	
}
