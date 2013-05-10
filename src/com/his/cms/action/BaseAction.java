/* 
 * Created by linzheyan at 2013-4-19 
 * Copyright HiSupplier.com 
 */

package com.his.cms.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.his.cms.util.LangUtil;
import com.his.cms.util.SessionUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author linzheyan
 *
 * 2013-4-19
 */
public class BaseAction extends ActionSupport {
	
	private static final long serialVersionUID = 6171507549237655943L;

	protected Map<String, Object> result = new HashMap<String, Object>(); 
	protected int pageNo = 0;
	protected int pageSize = 1;
	protected static String JSON = "json";
	
	protected String getCreator() {
		return SessionUtil.getSessionUser(ServletActionContext.getRequest()).getName();
	}
	
	protected String getCurrentTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	protected int getLang() {
		return LangUtil.getLang(ServletActionContext.getRequest());
	}
	
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
