/**
 * 
 */
package com.his.cms.model;

/**
 * @author ������
 *
 * creat in 2013-4-21
 */
public class Menu extends BaseEntity {

	private static final long serialVersionUID = -5727324108938791644L;

	private String name;
	private String nameEn;
	private int listOrder;
	private String url;
	private int type; //1=����ҳ��  2=�ض����� 3=������Ѷ��
	private int isShow; // 0=չʾ 1=����

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
