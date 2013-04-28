/* 
 * Created by linzheyan at 2012-11-29 
 * Copyright HiSupplier.com 
 */

package com.his.cms.model;

import java.io.Serializable;


/**
 * 
 * 上传文件
 * @author linzheyan
 *
 * 2012-11-29
 */
public class Image extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 5990326839360831979L;

	/**
	 * 保存的文件名
	 */
	private String saveFile;
	/**
	 * 源文件名称
	 */
	private String name;

	/**
	 * 文件类别 1=manual
	 */
	private int type;
	
	public String getSaveFile() {
		return saveFile;
	}

	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
