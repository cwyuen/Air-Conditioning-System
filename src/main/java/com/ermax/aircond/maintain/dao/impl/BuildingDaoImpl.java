package com.ermax.aircond.maintain.dao.impl;

import org.springframework.stereotype.Repository;

import com.ermax.aircond.maintain.dao.BuildingDao;
import com.ermax.aircond.maintain.domain.Building;
import com.ermax.aircond.util.dao.AbstractHibernateDaoImpl;

@Repository("buildingDao")
public class BuildingDaoImpl extends AbstractHibernateDaoImpl<Building> implements BuildingDao, java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	public BuildingDaoImpl(){
		setClazz(Building.class);
	}
		

}
