package com.mcnc.example.springmvc.base.util;

import java.util.Locale;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.i18n.LocaleContextHolder;

import com.mcnc.example.springmvc.base.AppContextHolder;

/**
 * Web Utils
 * @author sotheara.leang
 *
 */
public class WebUtils implements InitializingBean {

	private static ServletContext servletContext;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		servletContext = AppContextHolder.getAppContext().getBean(ServletContext.class);
	}
	
	/**
	 * Get request locale
	 * @return
	 */
	public static Locale getLocale() {
		return LocaleContextHolder.getLocale();
	}
	
	/**
	 * Get context path
	 * @return
	 */
	public static String getContextPath() {
		return servletContext.getContextPath();
	}
}
