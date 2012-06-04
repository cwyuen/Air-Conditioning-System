package com.ermax.aircond.maintain.web.bean;

import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ermax.aircond.common.domain.UserDetail;
import com.ermax.aircond.common.domain.UserGroup;
import com.ermax.aircond.common.web.bean.LoginBean;

@Scope("request")
@Component
public class UserMaintainBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;	
	private UserDetail userDetail;
	private List<UserGroup> userGroupOptions;

}
