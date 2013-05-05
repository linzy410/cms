/**
 * 
 */
package com.his.cms.util;

/**
 * @author 林哲炎
 *
 * creat in 2013-4-19
 */
public interface IConstants {


	/** 语言 */
	public static int CN = 0;
	public static int EN = 1;
	
	public static int IMAGE_TYPE_NEWS = 1; 
	public static int IMAGE_TYPE_SPACE = 2;
	
	/** 菜单类别  1=单张页面  2=特定链接 3=新闻资讯类*/
	public static int MENU_TYPE_PAGE = 1; 
	public static int MENU_TYPE_ASSIGN = 2; 
	public static int MENU_TYPE_NEWS_LIST = 3;
	
	public static String KEY_FILE_UPLOAD_SAVE_PATH = "file.upload.save.path";
	
	public static int HYPERLINK_STATE_ACTIVE = 1;
	public static int HYPERLINK_STATE_DISABLED = 2;
	public static int HYPERLINK_STATE_NOMAL = 3;
	
	public static String SLASH = "/";
}
