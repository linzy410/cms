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
 * @author ¡÷’‹—◊
 *
 * creat in 2013-5-8
 */
public class MenuPageBuilder extends HtmlBuilder {
	
	private MenuService menuService = (MenuService) Global.getBean("menuService");
	private Menu menu;

	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#getContextMap()
	 */
	@Override
	protected Map<String, VelocityContext> getContextMap() throws SQLException {
		Map<String, VelocityContext> map = new HashMap<String, VelocityContext>();
		List<Menu> menus = menuService.getMenuListByType(IConstants.MENU_TYPE_PAGE);
		for (Menu menu : menus) {
			this.menu = menu;
			VelocityContext context = new VelocityContext();
			MenuContent content = menuService.getMenuContent(menu.getId());
			context.put("content", content.getContent());
			map.put("index.html", context);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#getFileOutPath()
	 */
	@Override
	protected String getFileOutPath() {
		return "cn/";
	}

	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#getVmName()
	 */
	@Override
	protected String getVmName() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#getActiveMenuId()
	 */
	@Override
	protected int getActiveMenuId() {
		return menu.getId();
	}

}
