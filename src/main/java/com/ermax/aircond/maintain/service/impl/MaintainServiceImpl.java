package com.ermax.aircond.maintain.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ermax.aircond.common.dao.UserDetailDao;
import com.ermax.aircond.common.dao.UserGroupDao;
import com.ermax.aircond.common.domain.UserDetail;
import com.ermax.aircond.common.domain.UserGroup;
import com.ermax.aircond.maintain.dao.BuildingDao;
import com.ermax.aircond.maintain.domain.Building;
import com.ermax.aircond.maintain.service.MaintainService;

@Service("maintainService")
public class MaintainServiceImpl implements MaintainService {

	@Autowired
	private UserGroupDao userGroupDao;
	@Autowired
	private UserDetailDao userDetailDao;
	@Autowired
	private BuildingDao buildingDao;
	
	
	@Override
	@Transactional(readOnly=true)
	public List<UserGroup> getAllUserGroups() {
		return userGroupDao.findAll();		
	}

	@Override
	@Transactional(readOnly=true)
	public List<UserGroup> getUserGroups(String search) {
		return userGroupDao.findUserGroupByKeyword(search);
	}
	
	@Override
	@Transactional
	public void createUserGroup(UserGroup userGroup,String userName) {
		Date currentDate = new Date();
		userGroup.setCreateUser(userName);
		userGroup.setCreateDate(currentDate);
		userGroup.setUpdateUser(userName);
		userGroup.setUpdateDate(currentDate);
		userGroupDao.create(userGroup);	
	}
	
	@Override
	@Transactional
	public void updateUserGroup(UserGroup userGroup, String userName) {
		Date currentDate = new Date();		
		userGroup.setUpdateUser(userName);
		userGroup.setUpdateDate(currentDate);
		userGroupDao.update(userGroup);	
		
	}
	
	@Override
	@Transactional
	public void deleteUserGroup(UserGroup userGroup) {
		userGroupDao.delete(userGroup);
	}

	@Override
	@Transactional(readOnly=true)
	public List<UserDetail> getAllUserDetails() {
		return userDetailDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<UserDetail> getUserDetails(String search) {
		return userDetailDao.findUserDetailByKeyword(search);
	}

	@Override
	@Transactional
	public void createUserDetail(UserDetail userDetail, String userName) {
		Date currentDate = new Date();
		userDetail.setCreateDate(currentDate);
		userDetail.setCreateUser(userName);
		userDetail.setUpdateDate(currentDate);
		userDetail.setUpdateUser(userName);
		userDetailDao.create(userDetail);
	}

	@Override
	@Transactional
	public void updateUserDetail(UserDetail userDetail, String userName) {
		userDetail.setUpdateDate(new Date());
		userDetail.setUpdateUser(userName);
		userDetailDao.update(userDetail);
	}

	@Override
	@Transactional
	public void deleteUserDetail(UserDetail userDetail) {
		userDetailDao.delete(userDetail);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Building> getAllBuildings() {
		return buildingDao.findAll();
	}

	@Override
	public List<Building> getBuildings(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBuilding(Building building, String userName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBuilding(Building building, String userName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBuilding(Building building) {
		// TODO Auto-generated method stub
		
	}

	
}
