package com.ermax.aircond.maintain.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ermax.aircond.common.domain.CommonDomain;

@Entity
@Table(name="FLOOR")
public class Floor extends CommonDomain implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="FLOOR_ID")
	private long floorId;	
	@ManyToOne
	@JoinColumn(name = "BUILDING_ID")
	private Building building;
	private int floorNo;
	private int floorName;
	private String status;
	private String floorType;
	private String description;
	
	public long getFloorId() {
		return floorId;
	}
	public void setFloorId(long floorId) {
		this.floorId = floorId;
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public int getFloorName() {
		return floorName;
	}
	public void setFloorName(int floorName) {
		this.floorName = floorName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFloorType() {
		return floorType;
	}
	public void setFloorType(String floorType) {
		this.floorType = floorType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
