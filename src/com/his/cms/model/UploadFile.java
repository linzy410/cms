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
public class UploadFile extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 5990326839360831979L;

	/**
	 * 保存的文件名
	 */
	private String fileName;
	/**
	 * 文件保存路径 
	 */
	private String filePath;

	/**
	 * 文件上传时的名称
	 */
	private String uploadName;
	
	/**
	 * 文件类别 1=manual
	 */
	private int type;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getUploadName() {
		return uploadName;
	}

	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
