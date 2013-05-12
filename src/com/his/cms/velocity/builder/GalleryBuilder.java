/**
 * 
 */
package com.his.cms.velocity.builder;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.VelocityContext;

import com.his.cms.model.Image;
import com.his.cms.service.ImageService;
import com.his.cms.util.Global;
import com.his.cms.util.IConstants;
import com.his.cms.velocity.HtmlBuilder;
import com.his.cms.velocity.HtmlPage;

/**
 * @author ¡÷’‹—◊
 *
 * creat in 2013-5-11
 */
public class GalleryBuilder extends HtmlBuilder {
	private ImageService imageService = (ImageService) Global.getBean("imageService");
	
	public void builder() throws Exception {
		super.builder(getContextMap(cn), cn);
		super.builder(getContextMap(en), en);
	}
	
	private Map<String, VelocityContext> getContextMap(String lang) throws SQLException {
		Map<String, VelocityContext> map = new HashMap<String, VelocityContext>();
		List<Image> images = null;
		if (lang.equals(super.cn))
			images = imageService.getImageList(IConstants.IMAGE_TYPE_SPACE, IConstants.CN);
		else
			images = imageService.getImageList(IConstants.IMAGE_TYPE_SPACE, IConstants.EN);
		int total = images.size();
		int pageSize = 12;
		int totalPageNo = total % pageSize == 0 ? total / pageSize - 1 : total / pageSize;
		for (int i = 0; i <= totalPageNo; i++) {
			VelocityContext context = new VelocityContext();
			context.put(super.lang, lang);
			context.put(activeMenuId, 0);
			int toIndex = (i + 1) * pageSize >= images.size() ? images.size() : (i + 1) * pageSize;
			HtmlPage page = new HtmlPage(images.subList(i * pageSize, toIndex), total, i, pageSize);
			page.setUrl(IConstants.SLASH + lang + IConstants.SLASH + "gallery" + IConstants.SLASH);
			context.put("page", page);
			if (i == 0) {
				map.put("index.html", context);
			} else {
				map.put("page-" + i + ".html", context);
			}
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#getFileOutPath()
	 */
	@Override
	protected String getFileOutPath() {
		return "gallery";
	}

	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#getVmName()
	 */
	@Override
	protected String getVmName() {
		return "gallery.vm";
	}

	public static void main(String[] args) throws Exception {
		GalleryBuilder builder = new GalleryBuilder();
		builder.builder();
	}
}
