package com.his.cms.dto;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable {

	private static final long serialVersionUID = -9103367921678297596L;
	
	private List<?> elements;
	private int total;
	private int startRow;
	private int pageSize;
	private String url;
	
	public Page(List<?> elements, int total) {
		this.elements = elements;
		this.total = total;
	}
	
	/** Ç°1Ò³Ò³Âë */
	public int getP1Page(){
		return startRow - 1;
	}
	/** Ç°2Ò³Ò³Âë */
	public int getP2Page() {
		return startRow - 2;
	}
	/** ºó1Ò³Ò³Âë */
	public int getN1Page() {
		return startRow + 1;
	}
	/** ºó2Ò³Ò³Âë */
	public int getN2Page() {
		return startRow + 2;
	}
	/** µ¹ÊýµÚ5Ò³Ò³Âë	 */
	public int getL5Page() {
		return getTotalPage() - 4;
	}
	
	public int getTotalPage() {
		return total / pageSize;
	}
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public String getPreviousPage() {
		if (startRow == 0)
			return "javascript:void(0);";
		return (startRow - 1) + ".html";
	}
	public String getNextPage() {
		if (startRow == getTotalPage())
			return "javascript:void(0);";
		return (startRow + 1) + ".html";
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

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
