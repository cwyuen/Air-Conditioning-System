package com.ermax.aircond.common.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ermax.aircond.common.dao.UserDetailDao;
import com.ermax.aircond.common.dao.UserGroupDao;
import com.ermax.aircond.common.domain.UserDetail;
import com.ermax.aircond.common.domain.UserGroup;
import com.ermax.aircond.common.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDetailDao userDetailDao;
	@Autowired
	private UserGroupDao userGroupDao;

	@Override
	@Transactional
	public void createUserGroup(UserGroup userGroup) {
		userGroupDao.create(userGroup);		
	}
		
	@Override
	@Transactional(readOnly=true)
	public UserDetail login(String username, String password) {
		UserDetail userDetail = userDetailDao.findAcUserByUsername(username);
		if(userDetail != null){
			if(password.equals(userDetail.getPassword())){
				return userDetail;
			}
		}		
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public List<UserGroup> getAllUserGroups() {
		return userGroupDao.findAll();
	}

	@Override
	@Transactional
	public void createUserDetail(UserDetail userDetail) {
		userDetailDao.create(userDetail);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<UserDetail> getAllUserDetails() {
		return userDetailDao.findAll();
	}

	
	
	
	
	
}
