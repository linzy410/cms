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
public class Image extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 5990326839360831979L;

	/**
	 * ������ļ���
	 */
	private String saveFile;
	/**
	 * Դ�ļ�����
	 */
	private String name;

	/**
	 * �ļ���� 1=manual
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
