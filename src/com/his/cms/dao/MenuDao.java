/**
 * 
 */
package com.his.cms.dao;

import java.sql.SQLException;
import java.util.List;

import com.his.cms.model.Menu;
import com.his.cms.model.MenuContent;

/**
 * @author 林哲炎
 *
 * creat in 2013-4-21
 */
public class MenuDao extends BaseDao {
	
	public void addMenu(Menu menu) {
		super.getSqlMapClientTemplate().insert("menu.addMenu", menu);
	}
	
	public void updateMenu(Menu menu) {
		super.getSqlMapClientTemplate().update("menu.updateMenu", menu);
	}
	
	public Menu findMenu(int id) {
		return (Menu) super.getSqlMapClientTemplate().queryForObject("menu.findMenu", id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Menu> findMenuList(int type) {
		return super.getSqlMapClientTemplate().queryForList("menu.findMenuList", type);
	}
	
	/**
	 * 展示的菜单
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Menu> findShowMenuList() {
		return super.getSqlMapClientTemplate().queryForList("menu.findShowMenuList");
	}
	
	
	public void deleteMenu(int id) {
		super.getSqlMapClientTemplate().delete("menu.deleteMenu", id);
	}

	/**
	 * 更新listOrder
	 * @param menus
	 * @throws SQLException
	 */
	public void updateMenuListOrder(List<Menu> menus) {
		super.getSqlMapClientTemplate().update("menu.updateMenuListOrder", menus);
	}
	
	/**
	 * 更新url
	 * @param menus
	 * @throws SQLException
	 */
	public void updateMenuUrl(List<Menu> menus) {
		super.getSqlMapClientTemplate().update("menu.updateMenuUrl", menus);
	}
	
	public MenuContent findMenuContent(int menuId) {
		return (MenuContent) super.getSqlMapClientTemplate().queryForObject("menu.findMenuContent", menuId);
	}
	
	public void addMenuContent(MenuContent content) {
		super.getSqlMapClientTemplate().insert("menu.addMenuContent", content);
	}
}
