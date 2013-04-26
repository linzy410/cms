/**
 * 
 */
package com.his.cms.action.admin;

import java.util.List;

import com.his.cms.action.BasePageAction;
import com.his.cms.model.Menu;
import com.his.cms.model.News;
import com.his.cms.service.MenuService;
import com.his.cms.service.NewsService;
import com.his.cms.service.UploadFileService;
import com.his.cms.util.IConstants;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author ¡÷’‹—◊
 *
 * creat in 2013-4-19
 */
public class NewsAction extends BasePageAction implements ModelDriven<News> {

	private static final long serialVersionUID = 4342284034206304094L;
	private NewsService newsService;
	private MenuService menuService;
	private UploadFileService uploadFileService;
	private News news = new News();
	private List<Menu> menus;
	
	public String list() throws Exception {
		page = newsService.getNewsPage(news, pageNo, pageSize);
		return "list";
	}
	
	public String add() throws Exception {
		menus = menuService.getMenuList(IConstants.MENU_TYPE_NEWS_LIST);
		return INPUT;
	}
	
	public String save() throws Exception {
		news.setCreateTime(super.getCurrentTime());
		news.setCreator("¿ÓÀƒ");
		newsService.saveNews(news);
		return "listAction";
	}
	
	public String uploadImage() throws Exception {
		return "upload";
	}
	
	public String showImage() throws Exception {
		result.put("images", uploadFileService.getUploadFileList(IConstants.IMAGE_TYPE_NEWS));
		return "showImage";
	}
	
	public String edit() throws Exception {
		news = newsService.getNewsById(selectedId);
		menus = menuService.getMenuList(IConstants.MENU_TYPE_NEWS_LIST);
		return INPUT;
	}
	
	public String update() throws Exception {
		newsService.updateNews(news);
		return "listAction";
	}
	
	public String remove() throws Exception {
		newsService.remove(selectedId);
		return "listAction";
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	public News getModel() {
		return news;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public News getNews() {
		return news;
	}

	public String getMenuTag() {
		return "news";
	}

	public void setUploadFileService(UploadFileService uploadFileService) {
		this.uploadFileService = uploadFileService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public List<Menu> getMenus() {
		return menus;
	}
}
