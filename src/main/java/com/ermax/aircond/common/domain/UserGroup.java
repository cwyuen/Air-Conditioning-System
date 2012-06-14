package com.ermax.aircond.common.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USERGROUP" ,uniqueConstraints = {@UniqueConstraint(columnNames = "DESCRIPTION")})
public class UserGroup extends CommonDomain implements java.io.Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USERGROUP_ID")
	private long userGroupId;
	private String groupName;
	private String description;		
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "userGroups", cascade={CascadeType.ALL})
	private List<UserDetail> userDetails;
		
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(long userGroupId) {
		this.userGroupId = userGroupId;
	}
	public List<UserDetail> getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}	
	
	
}
