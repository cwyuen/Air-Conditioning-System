package com.ermax.aircond.common.dao;

import java.util.List;

import com.ermax.aircond.common.domain.UserDetail;

public interface UserDetailDao {
	public List<UserDetail> getUserDetailByUserGroup(String userGroup);
	public UserDetail getUserDetailById(long id);
	public UserDetail getUserDetailByUsername(String username);
	public void add(UserDetail userDetail);
	
}
