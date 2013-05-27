package com.his.cms.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author <a href="mailto:linzheyan@viewlinecn.com">林哲炎</a> 
 * created in 2008-7-24
 */
public class CookieUtil {
//	private Log log = LogFactory.getLog(CookieUtil.class);
	
	private static final String COOKIE_ROOT_PATH = "/";
	
	/**
	 * 存入Cookie
	 * @param response
	 * @param key   	key
	 * @param value		值
	 * @param expiry    有效时间
	 * @param path		路径
	 * @param domain	
	 */
	private static void setCookie(HttpServletResponse response, String key, String value, int expiry, String path, String domain){
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(expiry);
		if(path != null)
			cookie.setPath(path);
		if(domain != null)
			cookie.setDomain(domain);
		response.addCookie(cookie);
	}
	
	/**
	 * 存入Cookie
	 * @param request
	 * @param response
	 * @param key
	 * @param value
	 */
	public static void setCookie(HttpServletResponse response, String key, String value){
		setCookie(response, key, value, -1, COOKIE_ROOT_PATH, null);
	}
	
	/**
	 * 读取Cookie
	 * @param request
	 * @param key
	 * @return cookie
	 */
	private static Cookie getCookie(HttpServletRequest request, String key){
		Cookie[] cookies = request.getCookies();
		if(cookies == null|| key == null || key.length() == 0)
			return null;
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals(key))
				return cookies[i];
		}
		return null;
	}
	
	/**
	 * 读取cookie值
	 * @param request
	 * @param key
	 * @return  cookie值
	 */
	public static String getCookieValue(HttpServletRequest request, String key){
		Cookie cookie = getCookie(request, key);
		return cookie != null ? cookie.getValue() : null;
	}
	
	/**
	 * 删除Cookie
	 * @param request
	 * @param response
	 * @param key
	 */
	public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String key){
		Cookie cookie = getCookie(request, key);
		if(cookie != null){
			cookie.setMaxAge(0);
			cookie.setPath(getPath(request));
			response.addCookie(cookie);
		}
	}
	
	/**
	 * 取路径
	 */
	private static String getPath(HttpServletRequest request) {
	     String path = request.getContextPath();
	    return (path == null || path.length()==0) ? COOKIE_ROOT_PATH : path;
	   }

}
