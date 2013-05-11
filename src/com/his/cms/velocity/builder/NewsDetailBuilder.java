/**
 * 
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

/**
 * @author ¡÷’‹—◊
 *
 * creat in 2013-5-11
 */
public class NewsDetailBuilder extends HtmlBuilder {
	
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
			for (News news : list) {
				VelocityContext context = new VelocityContext();
				context.put(super.lang, lang);
				context.put("menu", menu);
				context.put("news", news);
				context.put(super.activeMenuId, menu.getId());
				context.put(super.relativeFolderPath, menu.getNameEnSiteShow());
				map.put("content-" + news.getId() + ".html", context);
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
		return "news_detail.vm";
	}

	public static void main(String[] args) throws Exception {
		NewsDetailBuilder builder = new NewsDetailBuilder();
		builder.builder();
	}
}
