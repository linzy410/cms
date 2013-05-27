/* 
 * Created by linzheyan at 2013-4-19 
 * Copyright HiSupplier.com 
 */

package com.his.cms.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.his.cms.model.User;
import com.his.cms.service.UserService;
import com.his.cms.util.CookieUtil;
import com.his.cms.util.DES;
import com.his.cms.util.IConstants;
import com.his.cms.util.LangUtil;
import com.his.cms.util.SessionUtil;

/**
 * @author linzheyan
 *
 * 2013-4-19
 */
public class LoginAction extends BaseAction {

	private static final long serialVersionUID = -4563886695584137855L;
	private Log log = LogFactory.getLog(LoginAction.class);
	
	private UserService userService; 
	private String username;
	private String password;
	private int remember;  //0=不记住 1=记住密码
	
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String code = CookieUtil.getCookieValue(request, IConstants.KEY_COOKIE_USER_REMEMBER_LOGIN);
		if (code != null) {
			try {
				int id = Integer.valueOf(DES.getInstance().decryptStr(code));
				User user = userService.getUserById(id);
				if (user != null) {
					doSession(user);
					return SUCCESS;
				}
			} catch (Exception e) {
			}
		}
		return LOGIN;
	}
	
	public String login() {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			addActionError("请输入用户名、密码");
			return "login";
		}
		User user = userService.getUserByUsernameAndPassword(username, password);
		if (user == null) {
			addActionError("用户名或密码错误！");
			return "login";
		}
		doSession(user);
		if (remember == 1) {
			try {
				String code = DES.getInstance().encryptStr(String.valueOf(user.getId()));
				CookieUtil.setCookie(ServletActionContext.getResponse(), IConstants.KEY_COOKIE_USER_REMEMBER_LOGIN, code);
			} catch (Exception e) {
				log.error("密码记住功能出错", e);
			}
		}
		return SUCCESS;
	}

	/**
	 *  登录成功, session记录用户、语言信息
	 * @param user
	 */
	private void doSession(User user) {
		HttpServletRequest request = ServletActionContext.getRequest();
		SessionUtil.setUserSession(user, request);
		int lang = LangUtil.getLang(request);
		SessionUtil.setLang(lang, request);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setRemember(int remember) {
		this.remember = remember;
	}

	public int getRemember() {
		return remember;
	}
}
