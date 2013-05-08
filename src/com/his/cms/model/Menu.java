/**
 * 
 */
package com.his.cms.model;

import org.apache.commons.lang.StringUtils;

import com.his.cms.util.IConstants;

/**
 * @author 林哲炎
 *
 * creat in 2013-4-21
 */
public class Menu extends BaseEntity {

	private static final long serialVersionUID = -5727324108938791644L;

	private String name;
	private String nameEn;
	private int listOrder;
	private String url;
	private int type; //1=单张页面  2=特定链接 3=新闻资讯类
	private int isShow; // 0=展示 1=隐藏

	
//	public String getNameEnSiteShow() {
//		return nameEn.toLowerCase().replaceAll(" ", StringUtils.EMPTY);
//	}
	
	public String getPageHyperlink() {
		if (type == IConstants.MENU_TYPE_ASSIGN) {
			return url;
		}
		if (type == IConstants.MENU_TYPE_NEWS_LIST) {
			return "/news/" + super.getId() + IConstants.SLASH;
		}
		if (type == IConstants.MENU_TYPE_PAGE) {
			return IConstants.SLASH + nameEn.toLowerCase().replaceAll(" ", StringUtils.EMPTY)  + IConstants.SLASH;
		}
		return StringUtils.EMPTY;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setListOrder(int listOrder) {
		this.listOrder = listOrder;
	}

	public int getListOrder() {
		return listOrder;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}

	public int getIsShow() {
		return isShow;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameEn() {
		return nameEn;
	}
}
