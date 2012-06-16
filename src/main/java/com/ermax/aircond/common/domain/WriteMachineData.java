/**
 * 
 */
package com.ermax.aircond.common.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Eric
 *
 */

@Entity
@Table(name="MData")
public class WriteMachineData extends CommonDomain implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -3176678522127068017L;

	@Id
	@Column(nullable = false)
	private int nid;
	
	@Id
	private String cmd;

	/**
	 * @return the nid
	 */
	public int getNid() {
		return nid;
	}

	/**
	 * @param nid the nid to set
	 */
	public void setNid(int nid) {
		this.nid = nid;
	}

	/**
	 * @return the cmd
	 */
	public String getCmd() {
		return cmd;
	}

	/**
	 * @param cmd the cmd to set
	 */
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
}
