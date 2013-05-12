/* 
 * Created by linzheyan at 2013-5-10 
 * Copyright HiSupplier.com 
 */

package com.his.cms.velocity.builder;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;

import com.his.cms.model.Menu;
import com.his.cms.model.News;
import com.his.cms.service.MenuService;
import com.his.cms.service.NewsService;
import com.his.cms.util.Global;
import com.his.cms.util.IConstants;
import com.his.cms.velocity.HtmlBuilder;
import com.his.cms.velocity.HtmlPage;

/**
 * @author linzheyan
 *
 * 2013-5-10
 */
public class MenuNewsListBuilder extends HtmlBuilder {
	
	private NewsService newsService = (NewsService) Global.getBean("newsService");
	private MenuService menuService = (MenuService) Global.getBean("menuService");
	
	public void builder() throws Exception {
		super.builder(getContextMap(cn), cn);
		super.builder(getContextMap(en), en);
	}
	
	private Map<String, VelocityContext> getContextMap(String lang) throws SQLException {
		Map<String, VelocityContext> map = new HashMap<String, VelocityContext>();
		List<Menu> menus = menuService.getMenuListByType(IConstants.MENU_TYPE_NEWS_LIST);
		for (Menu menu : menus) {
			List<News> list = null;
			if (lang.equals(cn)) {
				list = newsService.getNewsList(null, menu.getId(), IConstants.CN);
			} else {
				list = newsService.getNewsList(null, menu.getId(), IConstants.EN);
			}
			int total = list.size();
			int pageSize = 5;
			int totalPageNo = total % pageSize == 0 ? total / pageSize - 1 : total / pageSize;
			for (int i = 0; i <= totalPageNo; i++) {
				VelocityContext context = new VelocityContext();
				context.put(relativeFolderPath, menu.getNameEnSiteShow());
				context.put(activeMenuId, menu.getId());
				context.put(super.lang, lang);
				int toIndex = (i + 1) * pageSize >= list.size() ? list.size() : (i + 1) * pageSize;
				HtmlPage page = new HtmlPage(list.subList(i * pageSize, toIndex), total, i, pageSize);
				page.setUrl(IConstants.SLASH + lang + IConstants.SLASH + menu.getNameEnSiteShow() + IConstants.SLASH);
				context.put("page", page);
				if (i == 0) {
					map.put("index.html", context);
				} else {
					map.put("page-" + i + ".html", context);
				}
			}
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#getFileOutPath()
	 */
	@Override
	protected String getFileOutPath() {
		return StringUtils.EMPTY;
	}

	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#getVmName()
	 */
	@Override
	protected String getVmName() {
		return "news_list.vm";
	}
	
	public static void main(String[] args) throws Exception {
		MenuNewsListBuilder builder = new MenuNewsListBuilder();
		builder.builder();
	}
	
}
