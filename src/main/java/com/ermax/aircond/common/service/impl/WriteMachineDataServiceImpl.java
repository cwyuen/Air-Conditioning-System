/**
 * 
 */
package com.ermax.aircond.common.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ermax.aircond.common.dao.WriteMachineDataDao;
import com.ermax.aircond.common.domain.WriteMachineData;
import com.ermax.aircond.common.service.WriteMachineDataService;

/**
 * @author Eric
 *
 */
@Service("writeMachineDataService")
public class WriteMachineDataServiceImpl implements WriteMachineDataService {

	private static final Logger logger = Logger.getLogger(WriteMachineDataService.class);
	
	@Autowired
	private WriteMachineDataDao writeMachineDataDao;
	
	/* (non-Javadoc)
	 * @see com.ermax.aircond.common.service.WriteMachineDataService#insert(com.ermax.aircond.common.domain.WriteMachineData)
	 */
	@Override
	@Transactional
	public int insert(WriteMachineData writeMachineData) {
		// TODO Auto-generated method stub
		logger.debug("Insert!");
		writeMachineDataDao.insert(writeMachineData);
		
		return 0;
	}

}
