/**
 * 
 */
package com.ermax.aircond.common.dao;

import java.util.List;

import com.ermax.aircond.common.domain.WriteMachineData;

/**
 * @author Eric
 *
 */
public interface WriteMachineDataDao {
	
	public void insert(WriteMachineData writeMachineData);
	public List<WriteMachineData> listData();
}
