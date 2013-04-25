/**
 * 
 */
package com.his.cms.action;


/**
 * @author ¡÷’‹—◊
 *
 * creat in 2013-4-21
 */
public abstract class BasePageAction extends BaseAction {

	private static final long serialVersionUID = -3535086611747121940L;
	
	protected int selectedId;
	protected String message;
	protected String operTag = "succ";
	
	protected abstract String getMenuTag();

	public int getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
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
}
