/* 
 * Created by linzheyan at 2013-4-19 
 * Copyright HiSupplier.com 
 */

package com.his.cms.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.his.cms.util.LangUtil;
import com.his.cms.util.SessionUtil;

/**
 * @author linzheyan
 *
 * 2013-4-19
 */
public class AdminAction extends BaseAction {

	private static final long serialVersionUID = -553495676873166601L;
	private int lang;

	public String execute() throws Exception{
		
		return SUCCESS;
	}
	
	public String lang() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		SessionUtil.setLang(lang, request);
		LangUtil.setLang(request, ServletActionContext.getResponse(), lang);
		return SUCCESS;
	}

	public int getLang() {
		return lang;
	}

	public void setLang(int lang) {
		this.lang = lang;
	}
}
