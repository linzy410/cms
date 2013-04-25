/* 
 * Created by linzheyan at 2013-4-25 
 * Copyright HiSupplier.com 
 */

package com.his.cms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * @author linzheyan
 *
 * 2013-4-25
 */
public class LangUtil {
	
	private static String KEY_LANG = "lang";
	
	public static void setLang(HttpServletRequest request, HttpServletResponse response, int lang) {
		CookieUtil.setCookie(request, response, KEY_LANG, String.valueOf(lang));
	}
	
	public static int getLang(HttpServletRequest request) {
		String lang = CookieUtil.getCookieValue(request, KEY_LANG);
		if (StringUtils.isEmpty(lang))
			return IConstants.CN;
		return Integer.parseInt(lang);
	}

}
