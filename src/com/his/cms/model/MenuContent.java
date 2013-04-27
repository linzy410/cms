/* 
 * Created by linzheyan at 2013-4-23 
 * Copyright HiSupplier.com 
 */

package com.his.cms.model;

import java.io.Serializable;

/**
 * @author linzheyan
 *
 * 2013-4-23
 */
public class MenuContent implements Serializable {

	private static final long serialVersionUID = -3660978953090921711L;

	private int menuId;
	private String content;
	
	private String menuName;
	private String menuNameEn;

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuNameEn(String menuNameEn) {
		this.menuNameEn = menuNameEn;
	}

	public String getMenuNameEn() {
		return menuNameEn;
	}
}
