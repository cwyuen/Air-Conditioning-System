package com.ermax.aircond.common.service;

import java.util.List;

import com.ermax.aircond.common.domain.UserDetail;
import com.ermax.aircond.common.domain.UserGroup;

public interface UserService {
	
	public void createUserGroup(UserGroup userGroup);
	public List<UserGroup> getAllUserGroups();
	
	
	
	public void createUserDetail(UserDetail userDetail);
	public List<UserDetail> getAllUserDetails();	
	public UserDetail login(String username, String password);
}
