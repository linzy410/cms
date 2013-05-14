/* 
 * Created by linzheyan at 2013-5-14 
 * Copyright HiSupplier.com 
 */

package com.his.cms.dao;

import com.his.cms.model.WebSite;

/**
 * @author linzheyan
 *
 * 2013-5-14
 */
public class WebSiteDao extends BaseDao {

	public void addWebSite(WebSite webSite) {
		super.getSqlMapClientTemplate().insert("webSite.addWebSite", webSite);
	}
	
	public WebSite findWebSite() {
		return (WebSite) super.getSqlMapClientTemplate().queryForObject("webSite.findWebSite");
	}
}
