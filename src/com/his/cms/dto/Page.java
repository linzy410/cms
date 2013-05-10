package com.his.cms.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.his.cms.util.IConstants;

public class Page implements Serializable {

	private static final long serialVersionUID = -9103367921678297596L;

	private List<?> elements;
	private int total;
	private int pageNo; // 当前页面
	private int pageSize;
	private String url;
	private List<Hyperlink> links = new ArrayList<Hyperlink>();
	private static String APOSTROPHE = "...";
	private static String POUND  = "javascript:void(0);";

	public Page(List<?> elements, int total, int pageSize) {
		this.elements = elements;
		this.total = total;
		this.pageSize = pageSize;
	}

	public List<Hyperlink> getLinks() {
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

	private String getUrl(int pageShowNo) {
		StringBuilder urlbuff = new StringBuilder(url);
		if (url.indexOf("?") > -1) {
			urlbuff.append("&");
		} else {
			urlbuff.append("?");
		}
		urlbuff.append("pageNo=").append(pageShowNo).append("&pageSize=").append(pageSize);
		return urlbuff.toString();
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

	class Hyperlink {
		private String href;
		private String name;
		private int state;

		public Hyperlink(String href, String name, int state) {
			this.href = href;
			this.name = name;
			this.state = state;
		}

		public String getHref() {
			return href;
		}

		public void setHref(String href) {
			this.href = href;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setState(int state) {
			this.state = state;
		}

		public int getState() {
			return state;
		}
	}
}
