package com.ermax.aircond.maintain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ermax.aircond.maintain.dao.BuildingDao;
import com.ermax.aircond.maintain.domain.Building;
import com.ermax.aircond.maintain.service.MaintainService;

@Service("maintainService")
public class MaintainServiceImpl implements MaintainService {

	@Autowired
	private BuildingDao buildingDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Building> getAllBuilding() {
		return buildingDao.findAll();
	}

}
