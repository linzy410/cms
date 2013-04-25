/**
 * 
 */
package com.his.cms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.his.cms.model.News;

/**
 * @author ¡÷’‹—◊
 *
 * creat in 2013-4-19
 */
public class NewsDao extends BaseDao {
	
	public void addNews(News news) {
		super.getSqlMapClientTemplate().insert("news.addNews", news);
	}
	
	public void updateNews(News news) {
		super.getSqlMapClientTemplate().update("news.updateNews", news);
	}
	
	public News findNews(int id) {
		return (News) super.getSqlMapClientTemplate().queryForObject("news.findNews", id);
	}
	
	@SuppressWarnings("unchecked")
	public List<News> findNewsList(News news, int pageNo, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", pageNo * pageSize);
		map.put("pageSize", pageSize);
		map.put("title", news.getTitle());
		map.put("type", news.getType());
		map.put("lang", news.getLang());
		return super.getSqlMapClientTemplate().queryForList("news.findNewsList", map);
	}
	
	public void deleteNews(int id) {
		super.getSqlMapClientTemplate().delete("news.deleteNews", id);
	}

}
