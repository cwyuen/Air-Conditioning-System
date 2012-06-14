package com.ermax.aircond.common.web.bean;

import java.io.Serializable;
import java.net.CookieStore;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.Cookie;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class LocaleBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String REQUEST_COOKIES_LOCALE_KEY = "REQUEST_COOKIES_LOCALE_KEY";
		
	private String language = "en";	
	
	@PostConstruct
	public void getCookieLocale(){
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		/*
		Map<String,Object> cookieMap = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
		if(cookieMap.containsKey(REQUEST_COOKIES_LOCALE_KEY)){
			Cookie cookie = (Cookie) cookieMap.get(REQUEST_COOKIES_LOCALE_KEY);
			try{
				locale = new Locale(cookie.getValue());
			}catch(Exception ex){}
		}*/
		language = locale.toString();
	}
	
	public void changeLanguage(ValueChangeEvent e){
		String language = e.getNewValue().toString();
		Locale locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		
		/*
		FacesContext.getCurrentInstance().getExternalContext().addResponseCookie(REQUEST_COOKIES_LOCALE_KEY, language, null);
		*/
	}
	

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}
