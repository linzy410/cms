/* 
 * Created by linzheyan at 2013-5-14 
 * Copyright HiSupplier.com 
 */

package com.his.cms.model;

import java.io.Serializable;

/**
 * @author linzheyan
 *
 * 2013-5-14
 */
public class WebSite implements Serializable {

	private static final long serialVersionUID = 7663781240019476259L;

	private String title;
	private String description;
	private String keywords;
	private String topImg;
	private String bottomImg;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getKeywords() {
		return keywords;
	}

	public String getTopImg() {
		return topImg;
	}

	public void setTopImg(String topImg) {
		this.topImg = topImg;
	}

	public String getBottomImg() {
		return bottomImg;
	}

	public void setBottomImg(String bottomImg) {
		this.bottomImg = bottomImg;
	}

}
