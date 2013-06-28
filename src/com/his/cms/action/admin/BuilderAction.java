/* 
 * Created by linzheyan at 2013-5-13 
 * Copyright HiSupplier.com 
 */

package com.his.cms.action.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.his.cms.action.BasePageAction;
import com.his.cms.dto.Builder;
import com.his.cms.velocity.AllBuilder;
import com.his.cms.velocity.HtmlBuilder;

/**
 * @author linzheyan
 *
 * 2013-5-13
 */
public class BuilderAction extends BasePageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6385892168937589962L;
	private static List<Builder> builders = new ArrayList<Builder>();
	private static Map<String, Builder> map = new HashMap<String, Builder>();
	private String key;
	static {
		Builder b1 =  new Builder("all", "全部", null);
		Builder b2 = new Builder("index", "首页", "com.his.cms.velocity.builder.IndexBuilder");  
		Builder b3 = new Builder("gallery", "照片图库", "com.his.cms.velocity.builder.GalleryBuilder");
		Builder b4 = new Builder("menunewslist", "新闻资讯", "com.his.cms.velocity.builder.MenuNewsListBuilder");
		Builder b5 = new Builder("menupage", "菜单详情", "com.his.cms.velocity.builder.MenuPageBuilder");
		Builder b6 = new Builder("newsdetail", "新闻详情", "com.his.cms.velocity.builder.NewsDetailBuilder");
			
		map.put(b1.getKey(), b1);
		map.put(b2.getKey(), b2);
		map.put(b3.getKey(), b3);
		map.put(b4.getKey(), b4);
		map.put(b5.getKey(), b5);
		map.put(b6.getKey(), b6);
		builders.add(b1);
		builders.add(b2);
		builders.add(b3);
		builders.add(b4);
		builders.add(b5);
		builders.add(b6);
	}
	
	
	public String list() throws Exception {
		return "list";
	}
	
	public String builder() throws Exception {
		if (StringUtils.isNotEmpty(key)) {
			Builder target = map.get(key);
			if (target != null) {
				try {
					if ("all".equals(key)) {
						AllBuilder builder = new AllBuilder();
						builder.builder();
					} else {
						HtmlBuilder builder = (HtmlBuilder) Class.forName(target.getClassName()).newInstance();
						builder.builder();
					}
				} catch (Exception e) {
				}
			}
		}
		return LISTACTION;
	}

	/* (non-Javadoc)
	 * @see com.his.cms.action.BasePageAction#getMenuTag()
	 */
	@Override
	public String getMenuTag() {
		return "builder";
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public static List<Builder> getBuilders() {
		return builders;
	}

}
