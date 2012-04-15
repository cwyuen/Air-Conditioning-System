package com.ermax.aircond.web.bean;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ermax.aircond.common.domain.UserDetail;
import com.ermax.aircond.common.service.UserService;

@Scope("session")
@Component()
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -5213143571414351589L;
	private String username;
	private String password;

	@Autowired
	private UserService userService;

	public String getUsername() {
		return username;
	}

	public String login() {
		UserDetail userDetail = userService.login(username, password);
		if (userDetail != null) {
			return "pages/common/welcome";
		} else {
			return "index";
		}
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
		JFreeChart chart = ChartFactory.createBarChart3D("title", "category",
				"range", dataset, PlotOrientation.VERTICAL, true, // include
																	// legend
				false, // tooltips
				false); // urls

		BufferedImage img = chart.createBufferedImage(500, // width
				375, // height
				BufferedImage.TYPE_INT_RGB, // image type
				null);
		ImageIO.write(img, "jpeg", out);
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
