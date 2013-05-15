/* 
 * Created by linzheyan at 2013-5-14 
 * Copyright HiSupplier.com 
 */

package com.his.cms.action.admin;

import org.apache.commons.lang.StringUtils;

import com.his.cms.action.BasePageAction;
import com.his.cms.model.WebSite;
import com.his.cms.service.WebSiteService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author linzheyan
 *
 * 2013-5-14
 */
public class WebSiteAction extends BasePageAction implements ModelDriven<WebSite> {
	
	private static final long serialVersionUID = 9072997799540364625L;
	private WebSiteService webSiteService;
	private WebSite webSite = new WebSite();
	
	public String list() throws Exception {
		webSite = webSiteService.getWebSite(super.getLang());
		return INPUT;
	}
	
	public String update() throws Exception {
		if (StringUtils.isEmpty(webSite.getTitle()))
			addActionError("网站标题不能为空");
		if (StringUtils.isEmpty(webSite.getTopImg()))
			addActionError("网站顶部banner不能为空");
		if (StringUtils.isEmpty(webSite.getBottomImg()))
			addActionError("网站底部banner不能为空");
		if (hasActionErrors())
			return INPUT;
		webSite.setLang(super.getLang());
		webSiteService.updateWebSite(webSite);
		return LISTACTION;
	}
	

	/* (non-Javadoc)
	 * @see com.his.cms.action.BasePageAction#getMenuTag()
	 */
	@Override
	protected String getMenuTag() {
		return "website";
	}

	public void setWebSiteService(WebSiteService webSiteService) {
		this.webSiteService = webSiteService;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	@Override
	public WebSite getModel() {
		return webSite;
	}

	public WebSite getWebSite() {
		return webSite;
	}
}
