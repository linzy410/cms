/* 
 * Created by linzheyan at 2013-5-10 
 * Copyright HiSupplier.com 
 */

package com.his.cms.velocity.builder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			int total = 0;
			if (lang.equals(cn)) {
				list = newsService.getNewsList(null, menu.getId(), IConstants.CN);
				total = newsService.getCountNews(null, menu.getId(), IConstants.CN);
			} else {
				list = newsService.getNewsList(null, menu.getId(), IConstants.EN);
				total = newsService.getCountNews(null, menu.getId(), IConstants.EN);
			}
			int pageSize = 5;
			int totalPageNo = total / pageSize;
			for (int i = 0; i <= totalPageNo; i++) {
				VelocityContext context = new VelocityContext();
				context.put(relativeFolderPath, menu.getNameEnSiteShow());
				context.put(activeMenuId, menu.getId());
				context.put(super.lang, lang);
				int toIndex = (i + 1) * pageSize >= list.size() ? list.size() : (i + 1) * pageSize;
				List<News> tmp = list.subList(i * pageSize, toIndex);
				
				HtmlPage page = new HtmlPage(tmp, total, i, pageSize);
				page.setUrl(IConstants.SLASH + lang + IConstants.SLASH + menu.getNameEnSiteShow() + IConstants.SLASH);
				context.put("page", page);
				if (i == 0) {
					map.put("index.html", context);
				} else {
					map.put("page-" + i + ".html", context);
				}
				//page = null;
				//tmp = null;
				//break;
			}
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
		return "news_list.vm";
	}
	
	public static void main(String[] args) throws Exception {
		MenuNewsListBuilder builder = new MenuNewsListBuilder();
		builder.builder();
//		List<Integer> list = new ArrayList<Integer>();
//		for (int i = 0; i < 22; i++) {
//			list.add(i);
//		}
//		for (int i = 0; i <= list.size() / 10; i++) {
//			for (Integer a : list.subList(i * 10, (i+1)*10>=list.size() ? list.size() : (i+1)*10)) {
//				System.out.print(a + " ");
//			}
//			System.out.println("");
//		}
	}
	
}
