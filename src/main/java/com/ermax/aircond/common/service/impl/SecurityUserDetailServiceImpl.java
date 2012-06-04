package com.ermax.aircond.common.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ermax.aircond.common.dao.UserDetailDao;
import com.ermax.aircond.common.domain.UserGroup;

@Service("securityUserDetailService")
public class SecurityUserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailDao userDetailDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.ermax.aircond.common.domain.UserDetail user = userDetailDao.findAcUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username");
		}

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (UserGroup userGroup : user.getUserGroups()) {
			authorities.add(new SimpleGrantedAuthority(userGroup.getGroupName()));
		}
		

		User userDetails = new User(username, user.getPassword(), user.isActive(), true, true, true, authorities);

		return userDetails;
	}

}
