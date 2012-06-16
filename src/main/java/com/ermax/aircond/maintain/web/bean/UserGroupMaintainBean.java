package com.ermax.aircond.maintain.web.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ermax.aircond.common.domain.UserGroup;
import com.ermax.aircond.maintain.service.MaintainService;
import com.ermax.aircond.util.web.bean.SortingTableBean;

@Scope("request")
@Component
public class UserGroupMaintainBean extends SortingTableBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private MaintainService maintainService;
	@ManagedProperty(value = "#{loginBean.sessionUser}")
	private String sessionUser;

	private List<UserGroup> userGroups;
	private UserGroup selectedUserGroup = new UserGroup();
	private String searchStr = "";
	private String action = "";

	@PostConstruct
	public void init() {
		userGroups = maintainService.getAllUserGroups();
	}

	public void search() {
		userGroups = maintainService.getUserGroups(searchStr);
	}

	public String createUserGroup() {
		maintainService.createUserGroup(selectedUserGroup, sessionUser);
		userGroups = maintainService.getAllUserGroups();
		return null;
	}

	public String getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(String sessionUser) {
		this.sessionUser = sessionUser;
	}

	public List<UserGroup> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}

	public UserGroup getSelectedUserGroup() {
		return selectedUserGroup;
	}

	public void setSelectedUserGroup(UserGroup selectedUserGroup) {
		this.selectedUserGroup = selectedUserGroup;
	}

	public String getSearchStr() {
		return searchStr;
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
