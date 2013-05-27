/* 
 * Created by linzheyan at 2013-4-19 
 * Copyright HiSupplier.com 
 */

package com.his.cms.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.his.cms.model.WebSite;
import com.his.cms.service.AdService;
import com.his.cms.service.ImageService;
import com.his.cms.service.NewsService;
import com.his.cms.service.WebSiteService;
import com.his.cms.util.IConstants;
import com.his.cms.util.LangUtil;
import com.his.cms.util.SessionUtil;

/**
 * @author linzheyan
 *
 * 2013-4-19
 */
public class AdminAction extends BaseAction {

	private static final long serialVersionUID = -553495676873166601L;
	private NewsService newsService;
	private ImageService imageService;
	private WebSiteService webSiteService;
	private AdService adService;
	private int lang;

	public String execute() throws Exception{
		int newsCount = newsService.getAllCount(super.getLang());
		int imageCount = imageService.getImageSpaceAllCount(super.getLang());
		WebSite webSite = webSiteService.getWebSite(super.getLang());
		int adCount = adService.getShowAdList(IConstants.AD_TYPE_BANNER).size();
		result.put("newsCount", newsCount);
		result.put("imageCount", imageCount);
		result.put("webSite", webSite);
		result.put("adCount", adCount);
		return SUCCESS;
	}
	
	public String lang() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		SessionUtil.setLang(lang, request);
		LangUtil.setLang(request, ServletActionContext.getResponse(), lang);
		return "lang";
	}

	public int getLang() {
		return lang;
	}

	public void setLang(int lang) {
		this.lang = lang;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	public void setWebSiteService(WebSiteService webSiteService) {
		this.webSiteService = webSiteService;
	}

	public void setAdService(AdService adService) {
		this.adService = adService;
	}
}
