/* 
 * Created by linzheyan at 2013-5-10 
 * Copyright HiSupplier.com 
 */

package com.his.cms.dto;

/**
 * @author linzheyan
 *
 * 2013-5-10
 */
public class Hyperlink {
	private String href;
	private String name;
	private int state;

	public Hyperlink(String href, String name, int state) {
		this.href = href;
		this.name = name;
		this.state = state;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}


}
