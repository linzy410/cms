/* 
 * Created by linzheyan at 2013-5-14 
 * Copyright HiSupplier.com 
 */

package com.his.cms.service;

import org.apache.commons.lang.StringUtils;

import com.his.cms.dao.WebSiteDao;
import com.his.cms.dto.UpdateMap;
import com.his.cms.model.WebSite;

/**
 * @author linzheyan
 *
 * 2013-5-14
 */
public class WebSiteService {
	
	private WebSiteDao webSiteDao;
	
	public WebSite getWebSite() {
		WebSite webSite = webSiteDao.findWebSite();
		if (webSite == null) {
			webSite = new WebSite();
			webSite.setTitle(StringUtils.EMPTY);
			webSite.setDescription(StringUtils.EMPTY);
			webSite.setKeywords(StringUtils.EMPTY);
			webSite.setTopImg(StringUtils.EMPTY);
			webSite.setBottomImg(StringUtils.EMPTY);
			webSiteDao.addWebSite(webSite);
		}
		return webSite;
	}

	public void saveWebSite(WebSite webSite) {
		webSiteDao.addWebSite(webSite);
	}
	
	public void updateWebSite(WebSite webSite) {
		UpdateMap updateMap = new UpdateMap("WebSite");
		updateMap.addField("title", webSite.getTitle());
		updateMap.addField("description", webSite.getDescription());
		updateMap.addField("keywords", webSite.getKeywords());
		updateMap.addField("topImg", webSite.getTopImg());
		updateMap.addField("bottomImg", webSite.getBottomImg());
		updateMap.addWhere("1", "1");
		webSiteDao.update(updateMap);
	}

	public void setWebSiteDao(WebSiteDao webSiteDao) {
		this.webSiteDao = webSiteDao;
	}
}
