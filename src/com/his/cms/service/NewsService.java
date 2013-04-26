/**
 * 
 */
package com.his.cms.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.his.cms.dao.NewsDao;
import com.his.cms.dto.Page;
import com.his.cms.model.News;

/**
 * @author ¡÷’‹—◊
 *
 * creat in 2013-4-19
 */
public class NewsService {
	
	private NewsDao newsDao;

	public Page getNewsPage(News news, int pageNo, int pageSize) {
		List<News> list = newsDao.findNewsList(news, pageNo, pageSize);
		int count = newsDao.findCountNews(news);
		Page page = new Page(list, count);
		String url = "/admin/news_list.action";
		StringBuilder params = new StringBuilder();
		if (news.getType() > 0) {
			params.append("&type=").append(news.getType());
		}
		if (StringUtils.isNotEmpty(news.getTitle())) {
			params.append("&title=").append(news.getTitle());
		}
		if (params.length() > 0)
			url += "?" + params.substring(1);
		page.setUrl(url);
		return page;
	}
	
	public News getNewsById(int id) {
		return newsDao.findNews(id);
	}
	
	public void saveNews(News news) {
		newsDao.addNews(news);
	}
	
	public void updateNews(News news) {
		newsDao.updateNews(news);
	}
	
	public void remove(int id) {
		newsDao.deleteNews(id);
	}
	
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
}
