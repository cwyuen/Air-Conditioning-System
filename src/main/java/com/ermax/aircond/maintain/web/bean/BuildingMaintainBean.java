package com.ermax.aircond.maintain.web.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.richfaces.component.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ermax.aircond.maintain.domain.Building;
import com.ermax.aircond.maintain.service.MaintainService;

@Scope("request")
@Component
public class BuildingMaintainBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MaintainService maintainService;
	
	private List<Building> buildingList = null;
	private SortOrder nameOrder = SortOrder.unsorted;
	private SortOrder statusOrder = SortOrder.unsorted;
	private SortOrder typeOrder = SortOrder.unsorted;
	private SortOrder descOrder = SortOrder.unsorted;
	
	
	
	@PostConstruct
	public void init(){
		if(buildingList == null){
			buildingList = maintainService.getAllBuilding();
		}
	}				
	
	public void sortByName(){
		resetOrders();
		if(nameOrder.equals(SortOrder.ascending)){
			nameOrder = SortOrder.descending;
		}else{
			nameOrder.equals(SortOrder.ascending);
		}
	}
	
	public void sortByStatus(){
		resetOrders();
		if(statusOrder.equals(SortOrder.ascending)){
			statusOrder = SortOrder.descending;
		}else{
			statusOrder.equals(SortOrder.ascending);
		}
	}
	
	public void sortByType(){
		resetOrders();
		if(typeOrder.equals(SortOrder.ascending)){
			typeOrder = SortOrder.descending;
		}else{
			typeOrder.equals(SortOrder.ascending);
		}
	}
	
	public void sortByDesc(){
		resetOrders();
		if(descOrder.equals(SortOrder.ascending)){
			descOrder = SortOrder.descending;
		}else{
			descOrder.equals(SortOrder.ascending);
		}
	}
	
	
	private void resetOrders(){
		nameOrder = SortOrder.unsorted;
		statusOrder = SortOrder.unsorted;
		typeOrder = SortOrder.unsorted;
		descOrder = SortOrder.unsorted;
	}

	public SortOrder getNameOrder() {
		return nameOrder;
	}

	public void setNameOrder(SortOrder nameOrder) {
		this.nameOrder = nameOrder;
	}

	public SortOrder getStatusOrder() {
		return statusOrder;
	}

	public void setStatusOrder(SortOrder statusOrder) {
		this.statusOrder = statusOrder;
	}

	public SortOrder getTypeOrder() {
		return typeOrder;
	}

	public void setTypeOrder(SortOrder typeOrder) {
		this.typeOrder = typeOrder;
	}

	public SortOrder getDescOrder() {
		return descOrder;
	}

	public void setDescOrder(SortOrder descOrder) {
		this.descOrder = descOrder;
	}

	public List<Building> getBuildingList() {
		return buildingList;
	}

	public void setBuildingList(List<Building> buildingList) {
		this.buildingList = buildingList;
	}

}
