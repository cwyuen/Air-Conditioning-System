package com.ermax.aircond.common.service;

import com.ermax.aircond.common.domain.UserDetail;

public interface UserService {
	public UserDetail login(String username, String password);
}
