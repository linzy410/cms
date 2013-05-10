/**
 * 
 */
package com.his.cms.velocity.builder;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.VelocityContext;

import com.his.cms.model.Menu;
import com.his.cms.model.MenuContent;
import com.his.cms.service.MenuService;
import com.his.cms.util.Global;
import com.his.cms.util.IConstants;
import com.his.cms.velocity.HtmlBuilder;

/**
 * 
 * 单张页面内容的菜单
 * 
 * @author 林哲炎
 *
 * creat in 2013-5-8
 */
public class MenuPageBuilder extends HtmlBuilder {
	
	private MenuService menuService = (MenuService) Global.getBean("menuService");

	public void builder() throws Exception {
		super.builder(getContextMap(cn), cn);
		super.builder(getContextMap(en), en);
	}

	private Map<String, VelocityContext> getContextMap(String lang) throws SQLException {
		Map<String, VelocityContext> map = new HashMap<String, VelocityContext>();
		List<Menu> menus = menuService.getMenuListByType(IConstants.MENU_TYPE_PAGE);
		for (Menu menu : menus) {
			VelocityContext context = new VelocityContext();
			MenuContent content = menuService.getMenuContent(menu.getId());
			if (lang.equals(cn))
				context.put("content", content.getContent());
			else
				context.put("content", content.getContentEn());
			context.put("menu", menu);
			context.put(relativeFolderPath, menu.getNameEnSiteShow());
			context.put(activeMenuId, menu.getId());
			context.put(super.lang, lang);
			map.put("index.html-menu-" + menu.getId(), context);
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#getFileOutPath()
	 */
	@Override
	protected String getFileOutPath() {
		return "";
	}

	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#getVmName()
	 */
	@Override
	protected String getVmName() {
		return "news_page.vm";
	}
	
	public static void main(String[] args) throws Exception {
		MenuPageBuilder builder = new MenuPageBuilder();
		builder.builder();
	}
}
