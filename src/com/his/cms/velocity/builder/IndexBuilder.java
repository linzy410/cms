/* 
 * Created by linzheyan at 2013-5-8 
 * Copyright HiSupplier.com 
 */

package com.his.cms.velocity.builder;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.VelocityContext;

import com.his.cms.model.Menu;
import com.his.cms.service.AdService;
import com.his.cms.service.MenuService;
import com.his.cms.util.Global;
import com.his.cms.util.IConstants;
import com.his.cms.velocity.HtmlBuilder;

/**
 * @author linzheyan
 *
 * 2013-5-8
 */
public class IndexBuilder extends HtmlBuilder {
	
	private MenuService menuService = (MenuService) Global.getBean("menuService");
	private AdService adService = (AdService) Global.getBean("adService");

	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#builder()
	 */
	@Override
	protected void builder() throws Exception {
		super.builder(getContextMap(cn), cn);
		super.builder(getContextMap(en), en);
	}
	
	private Map<String, VelocityContext> getContextMap(String lang) throws SQLException {
		Map<String, VelocityContext> map = new HashMap<String, VelocityContext>();
		VelocityContext context = new VelocityContext();
		context.put("ads", adService.getShowAdList(IConstants.AD_TYPE_BANNER));
		Menu menu = menuService.getMenuByName("Ê×Ò³");
		context.put(super.activeMenuId, menu.getId());
		context.put(super.lang, lang);
		map.put("index.html", context);
		return map;
	}

	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#getFileOutPath()
	 */
	@Override
	protected String getFileOutPath() {
		return "";
	}
	
	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#getVmName()
	 */
	@Override
	protected String getVmName() {
		return "index.vm";
	}

	public static void main(String[] args) throws Exception {
		IndexBuilder builder = new IndexBuilder();
		builder.builder();
	}
}
