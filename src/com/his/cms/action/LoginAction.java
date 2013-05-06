/* 
 * Created by linzheyan at 2013-4-19 
 * Copyright HiSupplier.com 
 */

package com.his.cms.action;

import com.his.cms.service.UserService;

/**
 * @author linzheyan
 *
 * 2013-4-19
 */
public class LoginAction extends BaseAction {

	private static final long serialVersionUID = -4563886695584137855L;
	
	private UserService userService; 
	private String username;
	private String password;
	
	public String login() {
		return "login";
	}
	
	public String execute() {
		
		return "admin";
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
}
