/* 
 * Created by linzheyan at 2012-11-29 
 * Copyright HiSupplier.com 
 */

package com.his.cms.model;

import java.io.Serializable;


/**
 * 
 * �ϴ��ļ�
 * @author linzheyan
 *
 * 2012-11-29
 */
public class UploadFile extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 5990326839360831979L;

	/**
	 * ������ļ���
	 */
	private String fileName;
	/**
	 * �ļ�����·�� 
	 */
	private String filePath;

	/**
	 * �ļ��ϴ�ʱ������
	 */
	private String uploadName;
	
	/**
	 * �ļ���� 1=manual
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
