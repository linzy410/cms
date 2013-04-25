/* 
 * Created by linzheyan at 2013-1-17 
 * Copyright HiSupplier.com 
 */

package com.his.cms.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * ibatis更新对象
 * 
 * @author linzheyan
 *
 * 2013-1-17
 */
public class UpdateMap {

	private String table;
	private List<Field> fields = new ArrayList<Field>();
	private List<Field> where = new ArrayList<Field>();

	/**
	 * @param table
	 */
	public UpdateMap(String table) {
		super();
		this.table = table;
	}

	/**
	 * @param name
	 * @param value
	 */
	public void addField(String name, String value) {
		fields.add(new Field(name, value, null));
	}

	/**
	 * @param name
	 * @param value
	 */
	public void addField(String name, int value) {
		fields.add(new Field(name, String.valueOf(value), null));
	}

	public void addField(String name, float value) {
		fields.add(new Field(name, String.valueOf(value), null));
	}

	/**
	 * 
	 * @param name
	 * @param value
	 * @param column  true=$输出 false=#输出
	 */
	public void addField(String name, String value, boolean column) {
		fields.add(new Field(name, value, "=", column));
	}

	/**
	 * 
	 * @param name
	 * @param vlaue
	 * @param operator
	 * @param column
	 */
	public void addField(String name, String value, String operator, boolean column) {
		fields.add(new Field(name, value, operator, column));
	}

	/**
	 * @param name
	 * @param value
	 */
	public void addWhere(String name, String value) {
		where.add(new Field(name, value, "="));
	}

	/**
	 * @param name
	 * @param value
	 */
	public void addWhere(String name, int value) {
		where.add(new Field(name, String.valueOf(value), "="));
	}

	/**
	 * @param name
	 * @param value
	 * @param operator
	 */
	public void addWhere(String name, String value, String operator) {
		where.add(new Field(name, value, operator));
	}

	/**
	 * @param name
	 * @param value
	 * @param operator
	 */
	public void addWhere(String name, int value, String operator) {
		where.add(new Field(name, value + "", operator));
	}

	/**
	 * 
	 * @param name
	 * @param value
	 * @param column  true=$输出 false=#输出
	 */
	public void addWhere(String name, String value, boolean column) {
		where.add(new Field(name, value, "=", column));
	}

	/**
	 * 
	 * @param name
	 * @param vlaue
	 * @param operator
	 * @param column
	 */
	public void addWhere(String name, String value, String operator, boolean column) {
		where.add(new Field(name, value, operator, column));
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public List<Field> getWhere() {
		return where;
	}

	public void setWhere(List<Field> where) {
		this.where = where;
	}
}
