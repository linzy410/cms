/* 
 * Created by linzheyan at 2013-1-17 
 * Copyright HiSupplier.com 
 */

package com.his.cms.dto;

/**
 * @author linzheyan
 *
 * 2013-1-17
 */
public class Field {
	private String name; // �ֶ�����
	private String value; // �ַ�ֵ
	private String operator; // sql������
	private boolean column = false; // true��ʾvalueΪsql���ʽ eg. col=col+1 ����ibatis��true=$value$��� false=#value#���

	/**
	 * @param name
	 * @param value
	 * @param operator
	 */
	public Field(String name, String value, String operator) {
		super();
		this.name = name;
		this.value = value;
		this.operator = operator;
	}

	public Field(String name, String value, String operator, boolean column) {
		super();
		this.name = name;
		this.value = value;
		this.operator = operator;
		this.column = column;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setColumn(boolean column) {
		this.column = column;
	}

	public boolean isColumn() {
		return column;
	}

}
