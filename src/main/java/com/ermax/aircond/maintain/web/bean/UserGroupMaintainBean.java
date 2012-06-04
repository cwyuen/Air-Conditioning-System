package com.ermax.aircond.maintain.web.bean;

import javax.faces.bean.ManagedProperty;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ermax.aircond.common.domain.UserDetail;
import com.ermax.aircond.common.domain.UserGroup;
import com.ermax.aircond.common.web.bean.LoginBean;

@Scope("request")
@Component
public class UserGroupMaintainBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private UserGroup userGroup = new UserGroup();
	
	public LoginBean getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	public UserGroup getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

}
