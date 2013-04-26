/**
 * 
 */
package com.his.cms.model;


/**
 * 新闻资讯
 * @author 林哲炎
 *
 * creat in 2013-4-19
 */
public class News extends BaseEntity {

	private static final long serialVersionUID = 7504363644345073726L;
	
	private String title;
	private int imageId;
	private String content;
	private int type; // 与menuId对应
	
	private String menuName;
	private String menuNameEn;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuNameEn(String menuNameEn) {
		this.menuNameEn = menuNameEn;
	}
	public String getMenuNameEn() {
		return menuNameEn;
	}
}
