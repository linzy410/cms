/* 
 * Created by linzheyan at 2012-11-29 
 * Copyright HiSupplier.com 
 */

package com.his.cms.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;

import com.his.cms.model.Image;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * @author linzheyan
 *
 * 2012-11-29
 */
public class ImageDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<Image> findImageList(int type, int lang, int pageNo, int pageSize) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("type", type);
		map.put("lang", lang);
		map.put("startRow", pageNo * pageSize);
		map.put("pageSize", pageSize);
		return super.getSqlMapClientTemplate().queryForList("image.findImageList", map);
	}
	
	public int findCountImage(int type, int lang) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("type", type);
		map.put("lang", lang);
		return (Integer) super.getSqlMapClientTemplate().queryForObject("image.findCountImage", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Image> findImageListByType(int type, int lang) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("type", type);
		map.put("lang", lang);
		return super.getSqlMapClientTemplate().queryForList("image.findImageListByType", map);
	}

	public int batchAdd(final List<Image> imageFiles) {
		return (Integer) getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				executor.startBatch();
				for (Image file : imageFiles) {
					executor.insert("image.addImage", file);
				}
				return executor.executeBatch();
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<Image> findImageByIds(String imageIds) {
		return super.getSqlMapClientTemplate().queryForList("image.findImageByIds", imageIds);
	}
	
	public void deleteImageByIds(String imageIds) {
		super.getSqlMapClientTemplate().delete("image.deleteImageByIds", imageIds);
	}
}
