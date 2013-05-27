/* 
 * Created by linzheyan at 2013-5-27 
 * Copyright HiSupplier.com 
 */

package com.his.cms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.his.cms.util.CookieUtil;
import com.his.cms.util.IConstants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author linzheyan
 *
 * 2013-5-27
 */
public class LogoutAction extends ActionSupport {

	private static final long serialVersionUID = -1351763731788347336L;

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		CookieUtil.deleteCookie(request, ServletActionContext.getResponse(), IConstants.KEY_COOKIE_USER_REMEMBER_LOGIN);
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return SUCCESS;
	}
}
