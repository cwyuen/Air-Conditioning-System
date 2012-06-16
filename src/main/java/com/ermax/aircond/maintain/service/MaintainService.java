package com.ermax.aircond.maintain.service;

import java.util.List;

import com.ermax.aircond.common.domain.UserDetail;
import com.ermax.aircond.common.domain.UserGroup;
import com.ermax.aircond.maintain.domain.Building;

public interface MaintainService {

	//User Group
	public List<UserGroup> getAllUserGroups();
	public List<UserGroup> getUserGroups(String search);
	public void createUserGroup(UserGroup userGroup,String userName);
	public void updateUserGroup(UserGroup userGroup, String userName);
	public void deleteUserGroup(UserGroup userGroup);
	
	//User Detail
	public List<UserDetail> getAllUserDetails();
	public List<UserDetail> getUserDetails(String search);
	public void createUserDetail(UserDetail userDetail, String userName);
	public void updateUserDetail(UserDetail userDetail, String userName);
	public void deleteUserDetail(UserDetail userDetail);
	
	//Building
	public List<Building> getAllBuildings();
	public List<Building> getBuildings(String search);
	public void createBuilding(Building building, String userName);
	public void updateBuilding(Building building, String userName);
	public void deleteBuilding(Building building);
}
