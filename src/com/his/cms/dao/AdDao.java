/**
 * 
 */
package com.his.cms.dao;

import java.util.List;

import com.his.cms.model.Ad;

/**
 * @author 林哲炎
 *
 * creat in 2013-4-21
 */
public class AdDao extends BaseDao {
	
	public void addAd(Ad ad) {
		super.getSqlMapClientTemplate().insert("ad.addAd", ad);
	}
	
	public Ad findAd(int id) {
		return (Ad) super.getSqlMapClientTemplate().queryForObject("ad.findAd", id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Ad> findAdList(int type) {
		return super.getSqlMapClientTemplate().queryForList("ad.findAdList", type);
	}
	
	/**
	 * 展示的广告
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Ad> findShowAdList(int type) {
		return super.getSqlMapClientTemplate().queryForList("ad.findShowAdList", type);
	}
	
	public void deleteAd(int id) {
		super.getSqlMapClientTemplate().delete("ad.deleteAd", id);
	}
}
