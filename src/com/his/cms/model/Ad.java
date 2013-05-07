/* 
 * Created by linzheyan at 2013-5-7 
 * Copyright HiSupplier.com 
 */

package com.his.cms.model;

/**
 * @author linzheyan
 *
 * 2013-5-7
 */
public class Ad extends BaseEntity {

	private static final long serialVersionUID = 5025336790082600325L;

	private String title;
	private int type;	// 1=首页banner
	private int isShow; // 0=展示 1=隐藏
	private int imgId;
	
	// 数据承载
	private String saveFile;
	private String name;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIsShow() {
		return isShow;
	}

	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}

	public String getSaveFile() {
		return saveFile;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
