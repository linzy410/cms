/**
 * 
 */
package com.his.cms.action.admin;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.his.cms.action.BasePageAction;
import com.his.cms.model.Menu;
import com.his.cms.model.MenuContent;
import com.his.cms.service.MenuService;
import com.his.cms.util.IConstants;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author 林哲炎
 *
 * creat in 2013-4-21
 */
public class MenuAction extends BasePageAction implements ModelDriven<Menu> {

	private static final long serialVersionUID = -2909775701590667802L;
	private MenuService menuService;
	private Menu menu = new Menu();
	private List<Menu> menus;
	private int type;
	private MenuContent content;

	public String list() {
		menus = menuService.getMenuListByType(type);
		return "list";
	}
	
	public String add() throws Exception {
		return INPUT;
	}
	
	public String save() throws Exception {
		validateMenu();
		if (hasActionErrors()) {
			return INPUT;
		}
		menu.setCreateTime(super.getCurrentTime());
		menu.setCreator(super.getCreator());
		menuService.saveMenu(menu);
		return LISTACTION;
	}
	
	private void validateMenu() {
		if (StringUtils.isEmpty(menu.getName())) {
			super.addActionError("菜单中文名称不能为空");
		}
		if (StringUtils.isEmpty(menu.getNameEn())) {
			super.addActionError("菜单英文名称不能为空");
		}
		if (menu.getType() == 0)
			super.addActionError("请选择一项类别");
	}
	
	public String remove() throws Exception {
		operTag = menuService.removeMenu(selectedId);
		return LISTACTION;
	}
	
	public String edit() throws Exception {
		menu = menuService.getMenuById(selectedId);
		return INPUT;
	}
	
	public String update() throws Exception {
		validateMenu();
		if (hasActionErrors())
			return INPUT;
		menuService.updateMenu(menu);
		return LISTACTION;
	}
	
	public String order() throws Exception {
		menus = menuService.getMenuListByType(0);
		return "order";
	}
	
	public String setOrder() throws Exception {
		menuService.setListOrder(menus);
		return LISTACTION;
	}
	
	/**
	 * 设置链接
	 * @return
	 * @throws Exception
	 */
	public String url() throws Exception {
		menus = menuService.getMenuListByType(IConstants.MENU_TYPE_ASSIGN);
		return "url";
	}
	
	public String setUrl() throws Exception {
		menuService.setUrl(menus);
		return LISTACTION;
	}
	
	/**
	 * 页面型菜单内容
	 * @return
	 * @throws Exception
	 */
	public String content() throws Exception {
		content = menuService.getMenuContent(selectedId);
		return "content";
	}
	
	public String updateContent() throws Exception {
		menuService.updateMenuContent(content);
		return LISTACTION;
	}
	

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	public Menu getModel() {
		return menu;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public List<Menu> getMenus() {
		return menus;
	}
	
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getMenuTag() {
		return "menu";
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setContent(MenuContent content) {
		this.content = content;
	}

	public MenuContent getContent() {
		return content;
	}
}
