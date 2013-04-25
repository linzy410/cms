/**
 * 
 */
package com.his.cms.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.his.cms.dao.MenuDao;
import com.his.cms.dto.UpdateMap;
import com.his.cms.model.Menu;
import com.his.cms.model.MenuContent;

/**
 * @author ������
 *
 * creat in 2013-4-21
 */
public class MenuService {
	
	private MenuDao menuDao;

	public List<Menu> getMenuList(int type) {
		return menuDao.findMenuList(type);
	}
	
	public Menu getMenuById(int id) {
		return menuDao.findMenu(id);
	}
	
	public void saveMenu(Menu menu) {
		menuDao.addMenu(menu);
	}
	
	public void updateMenu(Menu menu) {
		menuDao.updateMenu(menu);
	}
	
	public void remove(int id) {
		menuDao.deleteMenu(id);
	}
	
	/**
	 * ����˳��
	 * @param listOrderStr  id��˳����ַ��� id,listOrder#...
	 * @throws SQLException 
	 */
	public void setListOrder(List<Menu> menus) {
		menuDao.updateMenuListOrder(menus);
	}
	
	public void setUrl(List<Menu> menus) {
		menuDao.updateMenuUrl(menus);
	}
	
	public MenuContent getMenuContent(int menuId) {
		MenuContent content = menuDao.findMenuContent(menuId);
		if (content == null) {
			content = new MenuContent();
			content.setMenuId(menuId);
			content.setContent(StringUtils.EMPTY);
			menuDao.addMenuContent(content);
		}
		return content;
	}
	
	public void updateMenuContent(MenuContent content) {
		UpdateMap map = new UpdateMap("MenuContent");
		map.addField("content", content.getContent());
		map.addWhere("menuId", content.getMenuId());
		menuDao.update(map);
	}
	
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
}
