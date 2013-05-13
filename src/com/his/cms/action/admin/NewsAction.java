/**
 * 
 */
package com.his.cms.action.admin;

import java.util.List;

import com.his.cms.action.BasePageAction;
import com.his.cms.model.Menu;
import com.his.cms.model.News;
import com.his.cms.service.ImageService;
import com.his.cms.service.MenuService;
import com.his.cms.service.NewsService;
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
	private ImageService imageService;
	private News news = new News();
	private List<Menu> menus;
	private String titleQuery;
	private int typeQuery;
	
	public String list() throws Exception {
		menus = menuService.getMenuListByType(IConstants.MENU_TYPE_NEWS_LIST);
		page = newsService.getNewsPage(titleQuery, typeQuery, super.getLang(), pageNo, pageSize);
		return "list";
	}
	
	public String add() throws Exception {
		menus = menuService.getMenuListByType(IConstants.MENU_TYPE_NEWS_LIST);
		return INPUT;
	}
	
	public String save() throws Exception {
		news.setCreateTime(super.getCurrentTime());
		news.setCreator(super.getCreator());
		news.setLang(getLang());
		newsService.saveNews(news);
		return LISTACTION;
	}
	
	public String uploadImage() throws Exception {
		return "upload";
	}
	
	public String showImage() throws Exception {
		result.put("images", imageService.getImageList(IConstants.IMAGE_TYPE_NEWS, super.getLang()));
		return "showImage";
	}
	
	public String edit() throws Exception {
		news = newsService.getNewsById(selectedId);
		menus = menuService.getMenuListByType(IConstants.MENU_TYPE_NEWS_LIST);
		return INPUT;
	}
	
	public String update() throws Exception {
		newsService.updateNews(news);
		return LISTACTION;
	}
	
	public String remove() throws Exception {
		newsService.remove(selectedId);
		return LISTACTION;
	}
	
	public String removeMulti() throws Exception {
		newsService.removeMulti(selectedIds);
		return LISTACTION;
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

	public void setUploadFileService(ImageService imageService) {
		this.imageService = imageService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public String getTitleQuery() {
		return titleQuery;
	}

	public void setTitleQuery(String titleQuery) {
		this.titleQuery = titleQuery;
	}

	public int getTypeQuery() {
		return typeQuery;
	}

	public void setTypeQuery(int typeQuery) {
		this.typeQuery = typeQuery;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}
}
