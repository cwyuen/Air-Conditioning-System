package com.ermax.aircond.maintain.web.bean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ermax.aircond.maintain.domain.Building;
import com.ermax.aircond.maintain.service.MaintainService;
import com.ermax.aircond.util.web.bean.SortingTableBean;

@Scope("view")
@Component
public class BuildingMaintainBean extends SortingTableBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(BuildingMaintainBean.class);
	
	@Autowired
	private MaintainService maintainService;

	private List<Building> buildingList = null;	

	@PostConstruct
	public void init() {
		logger.debug("BuildingMaintainBean - init()");
		if (buildingList == null) {
			buildingList = maintainService.getAllBuildings();
		}
	}

	public List<Building> getBuildingList() {
		return buildingList;
	}

	public void setBuildingList(List<Building> buildingList) {
		this.buildingList = buildingList;
	}	

}
