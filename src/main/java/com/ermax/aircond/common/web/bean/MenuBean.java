package com.ermax.aircond.common.web.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class MenuBean implements java.io.Serializable{	
	
	private static final long serialVersionUID = 1L;

	public String doBuildingMaintain(){
		return "pages/maintain/building";
	}
	
	public String doUserGroupMaintain(){
		return "pages/maintain/usergroup";
	}
}
