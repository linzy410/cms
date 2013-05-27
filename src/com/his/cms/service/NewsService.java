/**
 * 
 */
package com.his.cms.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.his.cms.dao.NewsDao;
import com.his.cms.dto.Page;
import com.his.cms.model.News;

/**
 * @author 林哲炎
 *
 * creat in 2013-4-19
 */
public class NewsService {
	
	private NewsDao newsDao;

	public Page getNewsPage(String title, int type, int lang, int pageNo, int pageSize) {
		List<News> list = newsDao.findNewsList(title, type, lang, pageNo, pageSize);
		int total = newsDao.findCountNews(title, type, lang);
		Page page = new Page(list, total, pageSize);
		String url = "/admin/news_list.action";
		StringBuilder params = new StringBuilder();
		if (type > 0) {
			params.append("&typeQuery=").append(type);
		}
		if (StringUtils.isNotEmpty(title)) {
			params.append("&titleQuery=").append(title);
		}
		if (params.length() > 0)
			url += "?" + params.substring(1);
		page.setUrl(url);
		return page;
	}
	
	public List<News> getNewsList(String title, int type, int lang) {
		return newsDao.findAllNewsList(title, type, lang);
	}
	
	public News getNewsById(int id) {
		return newsDao.findNews(id);
	}
	
	public void saveNews(News news) {
		dealImgAndSummary(news);
		newsDao.addNews(news);
	}
	
	public void updateNews(News news) {
		dealImgAndSummary(news);
		newsDao.updateNews(news);
	}

	/**
	 * 处理列表时所展示图片和摘要
	 * @param news
	 */
	private void dealImgAndSummary(News news) {
		String content = news.getContent();
		Document doc = Jsoup.parse(content);
		Elements elements = doc.select("img");
		if (elements.size() > 0) {
			news.setImgPath(elements.get(0).attr("src"));
		} else {
			news.setImgPath(StringUtils.EMPTY);
		}
		String text = doc.text().trim();
		if (text.length() > 150)
			news.setSummary(text.substring(0, 180) + "...");
		else
			news.setSummary(text);
	}
	
	public int getAllCount(int lang) {
		return newsDao.findCountNews(null, 0, lang);
	}
	
	public void remove(int id) {
		newsDao.deleteNews(id);
	}
	
	public void removeMulti(String newsIds) {
		if (StringUtils.isNotEmpty(newsIds))
			newsDao.deleteNewsMulti(newsIds);
	}
	
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
}
