package com.mcnc.example.springmvc.base.util;

import java.util.Locale;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.mcnc.example.springmvc.base.AppContextHolder;

/**
 * Message Source Utils
 * @author sotheara.leang
 *
 */
public class MessageUtils implements InitializingBean {

	private static MessageSource messageSource;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		messageSource = AppContextHolder.getBean(MessageSource.class);
	}
	
	/**
	 * Get message with message code with its params and locale
	 * @param messageCode
	 * @param params
	 * @param locale
	 * @return
	 */
	public static String getMessage(String messageCode, Object[] params, Locale locale) {
		return messageSource.getMessage(messageCode, params, locale);
	}
	
	/**
	 * Get message with message code and its params
	 * @param messageCode
	 * @param params
	 * @return
	 */
	public static String getMessage(String messageCode, Object[] params) {
		return messageSource.getMessage(messageCode, params, LocaleContextHolder.getLocale());
	}
	
	/**
	 * Get message with message code
	 * @param messageCode
	 * @return
	 */
	public static String getMessage(String messageCode) {
		return getMessage(messageCode, null);
	}
}
