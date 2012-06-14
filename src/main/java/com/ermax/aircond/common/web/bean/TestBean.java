/**
 * 
 */
package com.ermax.aircond.common.web.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ermax.aircond.common.domain.WriteMachineData;
import com.ermax.aircond.common.service.WriteMachineDataService;

/**
 * @author Eric
 *
 */

@Scope("session")
@Component
@ManagedBean(name = "testBean")
public class TestBean implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -476200322932685461L;
	@Autowired
	private WriteMachineDataService writeMachineDataService;
	
	private static final Logger logger = Logger.getLogger(TestBean.class);
	
	@NotNull
	@Size(min = 1, max = 2)
	private String nid;

	@NotNull
	@Size(min = 1, max = 64)
	private String cmd;
	
	
	
	public String insert() throws IOException, ServletException {
		
		logger.debug("Insert page: " + this.getCmd() + ", " + this.getNid());
		
		WriteMachineData writeMachineData = new WriteMachineData();
		writeMachineData.setCmd(this.getCmd());
		writeMachineData.setNid(Integer.parseInt(this.getNid()));
		
		writeMachineDataService.insert(writeMachineData);
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpServletResponse  response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
		HttpSession session = request.getSession(false);
		
		response.sendRedirect("test.jsf");
		return null;
	}


	/**
	 * @return the nid
	 */
	public String getNid() {
		return nid;
	}


	/**
	 * @param nid the nid to set
	 */
	public void setNid(String nid) {
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
