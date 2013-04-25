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
	private String name; // 字段名称
	private String value; // 字符值
	private String operator; // sql操作符
	private boolean column = false; // true表示value为sql表达式 eg. col=col+1 既在ibatis中true=$value$输出 false=#value#输出

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
