/* 
 * Created by linzheyan at 2013-5-13 
 * Copyright HiSupplier.com 
 */

package com.his.cms.dto;


/**
 * @author linzheyan
 *
 * 2013-5-13
 */
public class Builder {

	private String title;
	private String className;
	private String key;
	
	public Builder(String key, String title, String className) {
		this.key = key;
		this.title = title;
		this.className = className;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
