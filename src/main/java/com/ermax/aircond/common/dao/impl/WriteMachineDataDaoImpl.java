/**
 * 
 */
package com.ermax.aircond.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ermax.aircond.common.dao.AbstractDao;
import com.ermax.aircond.common.dao.WriteMachineDataDao;
import com.ermax.aircond.common.domain.WriteMachineData;

/**
 * @author Eric
 *
 */
@Repository("writeMachineDataDao")
public class WriteMachineDataDaoImpl extends AbstractDao implements WriteMachineDataDao {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1418603846702420259L;

	
	/* (non-Javadoc)
	 * @see com.ermax.aircond.common.dao.WriteMachineDataDao#create(com.ermax.aircond.common.domain.WriteMachineData)
	 */
	@Override
	public void insert(WriteMachineData writeMachineData) {
		this.getSessionFactory().getCurrentSession().saveOrUpdate(writeMachineData);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<WriteMachineData> listData() {
		
		return this.getSessionFactory().getCurrentSession().createQuery("FROM MData ").list();
		
	}

}
