package com.ermax.aircond.maintain.dao.impl;

import org.springframework.stereotype.Repository;

import com.ermax.aircond.maintain.dao.FloorDao;
import com.ermax.aircond.maintain.domain.Floor;
import com.ermax.aircond.util.dao.AbstractHibernateDaoImpl;

@Repository("floorDao")
public class FloorDaoImpl extends AbstractHibernateDaoImpl<Floor> implements FloorDao, java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	public FloorDaoImpl(){
		setClazz(Floor.class);
	}
		

}
