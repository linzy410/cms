/**
 * 
 */
package com.his.cms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ¡÷’‹—◊
 * 
 *         creat in 2013512
 */
public class LangUtil {
	private static String KEY_LANG = "cms.lang";

	public static void setLang(HttpServletRequest request, HttpServletResponse response, int lang) {
		CookieUtil.setCookie(response, KEY_LANG, String.valueOf(lang));
	}

	public static int getLang(HttpServletRequest request) {
		String lang = CookieUtil.getCookieValue(request, KEY_LANG);
		try { 
			return Integer.parseInt(lang);
		} catch (Exception e) {
			return IConstants.CN;
		}
	}
}