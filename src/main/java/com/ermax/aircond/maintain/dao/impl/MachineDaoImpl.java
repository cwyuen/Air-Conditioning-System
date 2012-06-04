package com.ermax.aircond.maintain.dao.impl;

import org.springframework.stereotype.Repository;

import com.ermax.aircond.maintain.dao.MachineDao;
import com.ermax.aircond.maintain.domain.Machine;
import com.ermax.aircond.util.dao.AbstractHibernateDaoImpl;

@Repository("machineDao")
public class MachineDaoImpl extends AbstractHibernateDaoImpl<Machine> implements MachineDao, java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	public MachineDaoImpl(){
		setClazz(Machine.class);
	}
		

}
