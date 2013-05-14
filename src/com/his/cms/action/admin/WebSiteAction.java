/* 
 * Created by linzheyan at 2013-5-14 
 * Copyright HiSupplier.com 
 */

package com.his.cms.action.admin;

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
		webSite = webSiteService.getWebSite();
		return SUCCESS;
	}
	
	public String update() throws Exception {
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
