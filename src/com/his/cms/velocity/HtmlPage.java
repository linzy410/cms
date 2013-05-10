package com.his.cms.velocity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.his.cms.dto.Hyperlink;
import com.his.cms.util.IConstants;

public class HtmlPage implements Serializable {

	private static final long serialVersionUID = -9103367921678297596L;

	private List<?> elements;
	private int total; // 总记录数
	private int pageNo; // 当前页面
	private int pageSize; // 分页显示数量
	private String url;
	private static String APOSTROPHE = "...";
	private static String POUND  = "javascript:void(0);";

	public HtmlPage(List<?> elements, int total, int pageNo, int pageSize) {
		this.elements = elements;
		this.total = total;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public List<Hyperlink> getLinks() {
		List<Hyperlink> links = new ArrayList<Hyperlink>();
		int totalPage = getTotalPage();
		if (totalPage <= 10) {
			for (int i = 0; i <= totalPage; i++) {
				links.add(getHyperlink(i == pageNo, i));
			}
		} else if (pageNo < 4) {
			for (int i = 0; i < 5; i++) {
				links.add(getHyperlink(i == pageNo, i));
			}
			links.add(new Hyperlink(POUND, APOSTROPHE, IConstants.HYPERLINK_STATE_DISABLED));
			links.add(getHyperlink(totalPage));
		} else if (pageNo > totalPage - 4) {
			links.add(getHyperlink(0));
			links.add(new Hyperlink(POUND, APOSTROPHE, IConstants.HYPERLINK_STATE_DISABLED));
			for (int i = totalPage - 4; i <= totalPage; i++) {
				links.add(getHyperlink(i == pageNo, i));
			}
		} else {
			links.add(getHyperlink(0));
			links.add(new Hyperlink(POUND, APOSTROPHE, IConstants.HYPERLINK_STATE_DISABLED));
			for (int i = pageNo - 2; i <= pageNo + 2; i++) {
				links.add(getHyperlink(i == pageNo, i));
			}
			links.add(new Hyperlink(POUND, APOSTROPHE, IConstants.HYPERLINK_STATE_DISABLED));
			links.add(getHyperlink(totalPage));
		}
		return links;
	}
	
	private Hyperlink getHyperlink(int pageNo) {
		return getHyperlink(false, pageNo);
	}

	/**
	 * 
	 * @param current 是否为当前页面, 当前页面的链接为# 
	 * @param pageNo 分页显示页码
	 * @return
	 */
	private Hyperlink getHyperlink(boolean current, int pageNo) {
		if (current)
			return new Hyperlink(POUND, String.valueOf(pageNo + 1), IConstants.HYPERLINK_STATE_ACTIVE);
		return new Hyperlink(getUrl(pageNo), String.valueOf(pageNo + 1), IConstants.HYPERLINK_STATE_NOMAL);
	}

	/**
	 * 
	 * @param pageNo 页面展示页码，比真实分页数大1
	 * @return
	 */
	private String getUrl(int pageNo) {
		if (pageNo == 0) {
			return url + "index.html";
		}
		return url + "page-" + pageNo + ".html";
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getTotalPage() {
		return total % pageSize == 0 ? total / pageSize - 1 : total / pageSize;
	}

	public String getPreviousPage() {
		if (pageNo == 0)
			return POUND;
		return getUrl(pageNo - 1);
	}

	public String getNextPage() {
		if (pageNo == getTotalPage())
			return POUND;
		return getUrl(pageNo + 1);
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	public void setElements(List<?> elements) {
		this.elements = elements;
	}

	public List<?> getElements() {
		return elements;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageNo() {
		return pageNo;
	}
}
