/* 
 * Created by linzheyan at 2013-4-25 
 * Copyright HiSupplier.com 
 */

package com.his.cms.model;

import java.io.Serializable;

/**
 * @author linzheyan
 * 
 *         2013-4-25
 */
public class User implements Serializable {

	private static final long serialVersionUID = 5036792394026149781L;

	private int id;
	private String username;
	private String password;
	private String name;
	private String createTime;
	
	private String checkPassword;

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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}

	public String getCheckPassword() {
		return checkPassword;
	}
}
