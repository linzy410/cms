/* 
 * Created by linzheyan at 2012-11-29 
 * Copyright HiSupplier.com 
 */

package com.his.cms.model;

import java.io.Serializable;

/**
 * @author linzheyan
 *
 * 2012-11-29
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -4884744507860182014L;

	private int id;
	private String creator;
	private String createTime;
	private int lang;

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

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreator() {
		return creator;
	}

	public void setLang(int lang) {
		this.lang = lang;
	}

	public int getLang() {
		return lang;
	}
}
