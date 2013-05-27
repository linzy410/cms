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
	public static int IMAGE_TYPE_AD = 3;
	public static int IMAGE_TYPE_MENU = 4;
	public static int IMAGE_TYPE_WEBSITE_BANNER = 5;
	
	/** 菜单类别  1=单张页面  2=特定链接 3=新闻资讯类*/
	public static int MENU_TYPE_PAGE = 1; 
	public static int MENU_TYPE_ASSIGN = 2; 
	public static int MENU_TYPE_NEWS_LIST = 3;
	
	public static String FILE_UPLOAD_SAVE_PATH = PropertiesUtil.getString("file.upload.save.path");
	public static String VELOCITY_VM_DIR = PropertiesUtil.getString("velocity.vm.dir");
	public static String VELOCITY_RUNTIME_LOG_FILE_DIR = PropertiesUtil.getString("velocity.log.dir");
	public static String VELOCITY_OUTPUT_DIR = PropertiesUtil.getString("velocity.output.dir");
	
	public static int HYPERLINK_STATE_ACTIVE = 1;
	public static int HYPERLINK_STATE_DISABLED = 2;
	public static int HYPERLINK_STATE_NOMAL = 3;
	
	public static String SLASH = "/";
	
	public static int AD_TYPE_BANNER = 1;
	
	public static String KEY_COOKIE_USER_REMEMBER_LOGIN = "remlogin";
}
