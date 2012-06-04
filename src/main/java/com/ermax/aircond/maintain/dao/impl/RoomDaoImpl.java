package com.ermax.aircond.maintain.dao.impl;

import org.springframework.stereotype.Repository;

import com.ermax.aircond.maintain.dao.RoomDao;
import com.ermax.aircond.maintain.domain.Room;
import com.ermax.aircond.util.dao.AbstractHibernateDaoImpl;

@Repository("roomDao")
public class RoomDaoImpl extends AbstractHibernateDaoImpl<Room> implements RoomDao, java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	public RoomDaoImpl(){
		setClazz(Room.class);
	}

}
