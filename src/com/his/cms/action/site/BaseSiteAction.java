/**
 * 
 */
package com.his.cms.action.site;

import com.his.cms.action.BaseAction;

/**
 * @author ажуэяв
 *
 * creat in 2013-4-28
 */
public class BaseSiteAction extends BaseAction {
	
	private static final long serialVersionUID = 8155675105517981932L;
	
	protected int menuId;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
}
