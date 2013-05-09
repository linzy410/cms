/**
 * 
 */
package com.his.cms.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.his.cms.dao.MenuDao;
import com.his.cms.dao.NewsDao;
import com.his.cms.dto.UpdateMap;
import com.his.cms.model.Menu;
import com.his.cms.model.MenuContent;

/**
 * @author 林哲炎
 *
 * creat in 2013-4-21
 */
public class MenuService {
	
	private MenuDao menuDao;
	private NewsDao newsDao;
	
	/**
	 * 展示中的菜单
	 * @return
	 */
	public List<Menu> getShowMenuList() {
		return menuDao.findShowMenuList();
	}

	/**
	 * 根据类型查找
	 * @param type
	 * @return
	 */
	public List<Menu> getMenuListByType(int type) {
		return menuDao.findMenuList(type);
	}
	
	public Menu getMenuById(int id) {
		return menuDao.findMenu(id);
	}
	
	public Menu getMenuByName(String name) {
		return menuDao.findMenuByName(name);
	}
	
	public void saveMenu(Menu menu) {
		menuDao.addMenu(menu);
	}
	
	public void updateMenu(Menu menu) {
		menuDao.updateMenu(menu);
	}
	
	public String removeMenu(int id) {
		int count = newsDao.findCountNewsByType(id);
		if (count > 0) {
			return "hasNews";
		}
		menuDao.deleteMenu(id);
		return "succ";
	}
	
	/**
	 * 保存顺序
	 * @param listOrderStr  id和顺序和字符串 id,listOrder#...
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
			content = menuDao.findMenuContent(menuId);
		}
		return content;
	}
	
	public void updateMenuContent(MenuContent content) {
		UpdateMap map = new UpdateMap("MenuContent");
		map.addField("content", content.getContent());
		map.addField("contentEn", content.getContentEn());
		map.addWhere("menuId", content.getMenuId());
		menuDao.update(map);
	}
	
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
}
