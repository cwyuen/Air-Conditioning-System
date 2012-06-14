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
@Table(name="SData")
public class ReadMachineData implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 5316593650776261347L;
	
	@Id
	@Column(nullable = false)
	private int idx;
	private int nid;
	private String data;
	private String timing;
	private String events;
	private String toll;
	private int link;
	private String rcmd;
	private String mark;
	private String name;
	
	/**
	 * @return the idx
	 */
	public int getIdx() {
		return idx;
	}
	/**
	 * @param idx the idx to set
	 */
	public void setIdx(int idx) {
		this.idx = idx;
	}
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
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
	/**
	 * @return the timing
	 */
	public String getTiming() {
		return timing;
	}
	/**
	 * @param timing the timing to set
	 */
	public void setTiming(String timing) {
		this.timing = timing;
	}
	/**
	 * @return the events
	 */
	public String getEvents() {
		return events;
	}
	/**
	 * @param events the events to set
	 */
	public void setEvents(String events) {
		this.events = events;
	}
	/**
	 * @return the toll
	 */
	public String getToll() {
		return toll;
	}
	/**
	 * @param toll the toll to set
	 */
	public void setToll(String toll) {
		this.toll = toll;
	}
	/**
	 * @return the link
	 */
	public int getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(int link) {
		this.link = link;
	}
	/**
	 * @return the rcmd
	 */
	public String getRcmd() {
		return rcmd;
	}
	/**
	 * @param rcmd the rcmd to set
	 */
	public void setRcmd(String rcmd) {
		this.rcmd = rcmd;
	}
	/**
	 * @return the mark
	 */
	public String getMark() {
		return mark;
	}
	/**
	 * @param mark the mark to set
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
