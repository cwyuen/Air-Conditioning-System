package com.ermax.aircond.common.dao;

import com.ermax.aircond.common.domain.UserDetail;

public interface UserDetailDao {
	public UserDetail findAcUserByUsername(String username);
}
