package com.ermax.aircond.maintain.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ermax.aircond.common.domain.CommonDomain;

@Entity
@Table(name="BUILDING", uniqueConstraints = { @UniqueConstraint(columnNames = "BUILDINGNAME") })
public class Building extends CommonDomain implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BUILDING_ID")
	private long buildingId;
	private String buildingName;
	private String status;
	private String buildingType;
	private String description;
	public long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(long buildingId) {
		this.buildingId = buildingId;
	}	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

}
