/**
 * 
 */
package com.his.cms.service;

import java.util.List;

import com.his.cms.dao.NewsDao;
import com.his.cms.model.News;

/**
 * @author ¡÷’‹—◊
 *
 * creat in 2013-4-19
 */
public class NewsService {
	
	private NewsDao newsDao;

	public List<News> getNewsList(News news, int pageNo, int pageSize) {
		return newsDao.findNewsList(news, pageNo, pageSize);
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
