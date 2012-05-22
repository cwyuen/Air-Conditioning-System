package com.ermax.aircond.common.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ermax.aircond.common.dao.UserDetailDao;
import com.ermax.aircond.common.domain.UserDetail;
import com.ermax.aircond.common.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDetailDao userDetailDao;	

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
	
	
}
