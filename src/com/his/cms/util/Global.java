package com.his.cms.util;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * @author <a href="mailto:chenhongwei@viewlinecn.com">³ÂºêÎ°</a> 
 * created in 2008-4-22
 *
 *
 */
public class Global {
	private static ApplicationContext _ctx = null;
	private static String defaultContextPath = "classpath*:spring/*.xml";

	public static void initContext(String contextPath) {
		_ctx = new ClassPathXmlApplicationContext(defaultContextPath);
	}

	public static ApplicationContext getContext() {
		if (_ctx == null) {
			initContext(defaultContextPath);
		}
		return _ctx;
	}

	public static ApplicationContext getContext(ServletContext sc) {
		if (_ctx == null) {
			_ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
		}
		return _ctx;
	}
	
	public static Object getBean(String beanName) {
		return getContext().getBean(beanName);
	}
}
