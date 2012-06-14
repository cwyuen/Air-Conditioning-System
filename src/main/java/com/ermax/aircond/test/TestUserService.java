package com.ermax.aircond.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ermax.aircond.common.domain.UserDetail;
import com.ermax.aircond.common.domain.UserGroup;
import com.ermax.aircond.common.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/applicationContext.xml", "file:src/main/webapp/WEB-INF/applicationSecurity.xml" })
@TransactionConfiguration
@Transactional
public class TestUserService extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserService userService;

	@Test	
	public void test() {
		
		UserGroup userGroup1 = new UserGroup();
		userGroup1.setGroupName("ROLE_ADMIN");
		userGroup1.setDescription("Admin User");
		userService.createUserGroup(userGroup1);

		UserGroup userGroup2 = new UserGroup();
		userGroup2.setGroupName("ROLE_SUPERUSER");
		userGroup2.setDescription("Super User");
		userService.createUserGroup(userGroup2);

		UserGroup userGroup3 = new UserGroup();
		userGroup3.setGroupName("ROLE_USER");
		userGroup3.setDescription("Normal User");
		userService.createUserGroup(userGroup3);			
		
		UserDetail user1 = new UserDetail();
		user1.setActive(true);
		user1.setEmail("1111@email.com");
		user1.setFirstname("FFFF1111");
		user1.setLastname("LLLL1111");
		user1.setNickname("NNNN1111");
		user1.setPhone("PPPP1111");
		user1.setUsername("user1");
		user1.setPassword("password1");
		List<UserGroup> userGroups1 = new ArrayList<UserGroup>();
		userGroups1.add(userGroup1);
		userGroups1.add(userGroup3);
		user1.setUserGroups(userGroups1);
		userService.createUserDetail(user1);
		
		
		UserDetail user2 = new UserDetail();
		user2.setActive(true);
		user2.setEmail("2222@email.com");
		user2.setFirstname("FFFF2222");
		user2.setLastname("LLLL2222");
		user2.setNickname("NNNN2222");
		user2.setPhone("PPPP2222");
		user2.setUsername("user2");
		user2.setPassword("password2");
		List<UserGroup> userGroups2 = new ArrayList<UserGroup>();
		userGroups2.add(userGroup2);
		userGroups2.add(userGroup3);
		user2.setUserGroups(userGroups2);
		userService.createUserDetail(user2);
		/*
		UserDetail user3 = new UserDetail();
		user3.setActive(true);
		user3.setEmail("3333@email.com");
		user3.setFirstname("FFFF3333");
		user3.setLastname("LLLL3333");
		user3.setNickname("NNNN3333");
		user3.setPhone("PPPP3333");
		user3.setUsername("user3");
		user3.setPassword("password3");
		userService.createUserDetail(user3);
		
		UserDetail user4 = new UserDetail();
		user4.setActive(true);
		user4.setEmail("4444@email.com");
		user4.setFirstname("FFFF4444");
		user4.setLastname("LLLL4444");
		user4.setNickname("NNNN4444");
		user4.setPhone("PPPP4444");
		user4.setUsername("user4");
		user4.setPassword("password4");
		userService.createUserDetail(user4);
		
		UserDetail user5 = new UserDetail();
		user5.setActive(true);
		user5.setEmail("5555@email.com");
		user5.setFirstname("FFFF5555");
		user5.setLastname("LLLL5555");
		user5.setNickname("NNNN5555");
		user5.setPhone("PPPP5555");
		user5.setUsername("user5");
		user5.setPassword("password5");
		userService.createUserDetail(user5);
		*/
		
		
		//List<UserGroup> userGroups = userService.getAllUserGroups();
		
		List<UserGroup> userGroups = user1.getUserGroups();
		Iterator<UserGroup> ugIter = userGroups.iterator();
		while(ugIter.hasNext()){
			UserGroup userGroup = ugIter.next();
			System.out.println(userGroup.getUserGroupId() + " - " +userGroup.getGroupName() + " - " + userGroup.getDescription());
		}
	}

}
