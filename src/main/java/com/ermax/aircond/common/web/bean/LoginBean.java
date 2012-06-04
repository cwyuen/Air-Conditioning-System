package com.ermax.aircond.common.web.bean;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

@Scope("session")
@Component
public class LoginBean implements Serializable {
	private static String SAVED_REQUEST = "WEBATTRIBUTES_SAVED_REQUEST";
	private static final long serialVersionUID = -5213143571414351589L;

	@NotNull
	@Size(min = 1, max = 20)
	private String username;

	@NotNull
	@Size(min = 1, max = 20)
	private String password;

	@Autowired
	private AuthenticationManager authenticationManager;

	public String login() throws IOException, ServletException {
		try {
			Authentication request = new UsernamePasswordAuthenticationToken(this.username, this.password);
			Authentication result = authenticationManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
		} catch (AuthenticationException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
			return null;
		}
				
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();  
	    HttpServletResponse  response = (HttpServletResponse )FacesContext.getCurrentInstance().getExternalContext().getResponse();  
	    HttpSession session = request.getSession(false);
	    
	    if(session != null){
	    	ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
	    	SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);  
	    	if(savedRequest != null){  
	    		context.redirect(savedRequest.getRedirectUrl());
	    	}
	    }
	    
	    FacesContext.getCurrentInstance().responseComplete();  
	    return null;    					
	}
	
	public String logout() throws IOException {
		this.username = "";
		this.password = "";
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath()+ "/j_spring_security_logout");
		FacesContext.getCurrentInstance().responseComplete();
		return null;
	}

	public void paint(OutputStream out, Object data) throws IOException {
		/*
		 * BufferedImage img = new BufferedImage(400, 400,
		 * BufferedImage.TYPE_INT_RGB); Graphics2D graphics2D =
		 * img.createGraphics(); graphics2D.setBackground(Color.black);
		 * graphics2D.setColor(Color.BLUE); graphics2D.clearRect(0,0,400,400);
		 * graphics2D.drawLine(5,5,400-5,400-5);
		 * graphics2D.drawChars(this.getUsername
		 * ().toCharArray(),0,getUsername().length(),40,15);
		 */
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(1, "ONE", "ONE");
		dataset.setValue(2, "TWO", "TWO");
		dataset.setValue(3, "THREE", "THREE");
		dataset.setValue(4, "FOUR", "FOUR");
		dataset.setValue(5, "FIVE", "FIVE");
		JFreeChart chart = ChartFactory.createBarChart3D("title", "category", "range", dataset, PlotOrientation.VERTICAL, true, // include
																																// legend
				false, // tooltips
				false); // urls

		BufferedImage img = chart.createBufferedImage(500, // width
				375, // height
				BufferedImage.TYPE_INT_RGB, // image type
				null);
		ImageIO.write(img, "jpeg", out);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
