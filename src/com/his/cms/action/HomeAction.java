/* 
 * Created by linzheyan at 2013-4-19 
 * Copyright HiSupplier.com 
 */

package com.his.cms.action;

import java.util.List;

import com.his.cms.model.Menu;
import com.his.cms.service.MenuService;

/**
 * @author linzheyan
 *
 * 2013-4-19
 */
public class HomeAction extends BaseAction {

	private static final long serialVersionUID = 86129058907673013L;
	private MenuService menuService;
	private List<Menu> menus;
	
	public String execute() {
		menus = menuService.getMenuListByType(0);
		return "home";
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public List<Menu> getMenus() {
		return menus;
	}
}
