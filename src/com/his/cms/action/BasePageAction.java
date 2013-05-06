/**
 * 
 */
package com.his.cms.action;

import com.his.cms.dto.Page;


/**
 * @author ¡÷’‹—◊
 *
 * creat in 2013-4-21
 */
public abstract class BasePageAction extends BaseAction {

	private static final long serialVersionUID = -3535086611747121940L;
	
	protected int selectedId;
	protected String selectedIds;
	protected String message;
	protected String operTag = "succ";
	protected Page page;
	
	
	protected abstract String getMenuTag();

	public int getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}

	public String getSelectedIds() {
		return selectedIds;
	}

	public void setSelectedIds(String selectedIds) {
		this.selectedIds = selectedIds;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getOperTag() {
		return operTag;
	}

	public Page getPage() {
		page.setPageNo(super.getPageNo());
		return page;
	}
}
