package com.mcnc.example.springmvc.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Application Context Holder
 * @author sotheara.leang
 *
 */
public class AppContextHolder implements ApplicationContextAware {

	private static ApplicationContext appContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		AppContextHolder.appContext = applicationContext;
	}

	/**
	 * Get Application Context
	 * @return
	 */
	public static ApplicationContext getAppContext() {
		return appContext;
	}
	
	/**
	 * Get bean by class
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		return appContext.getBean(clazz);
	}
	
	/**
	 * Get bean by name
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		return appContext.getBean(beanName);
	}
}
