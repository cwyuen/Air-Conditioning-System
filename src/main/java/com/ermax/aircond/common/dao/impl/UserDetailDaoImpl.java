package com.ermax.aircond.common.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	@Transactional(readOnly = true)
	public List<UserDetail> findUserDetailByKeyword(String keyword) {
		StringBuilder sbKey = new StringBuilder();
		sbKey.append("%");
		sbKey.append(keyword);
		sbKey.append("%");
		String key = sbKey.toString();
		
		Criteria criteria = getCurrentSession().createCriteria(UserDetail.class);
		criteria.add(Restrictions.like("username", key));
		criteria.add(Restrictions.like("firstname", key));
		criteria.add(Restrictions.like("lastname", key));
		criteria.add(Restrictions.like("nickname", key));
		criteria.add(Restrictions.like("email", key));
		criteria.add(Restrictions.like("phone", key));
		
		@SuppressWarnings("unchecked")
		List<UserDetail> results = criteria.list();		
		return results;
	}
	

}
