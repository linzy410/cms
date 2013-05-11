/**
 * 
 */
package com.his.cms.velocity.builder;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.VelocityContext;

import com.his.cms.velocity.HtmlBuilder;

/**
 * @author ¡÷’‹—◊
 *
 * creat in 2013-5-11
 */
public class GalleryBuilder extends HtmlBuilder {
	
	public void builder() throws Exception {
		super.builder(getContextMap(cn), cn);
		super.builder(getContextMap(en), en);
	}
	
	private Map<String, VelocityContext> getContextMap(String lang) throws SQLException {
		Map<String, VelocityContext> map = new HashMap<String, VelocityContext>();
		return map;
	}

	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#getFileOutPath()
	 */
	@Override
	protected String getFileOutPath() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.his.cms.velocity.HtmlBuilder#getVmName()
	 */
	@Override
	protected String getVmName() {
		// TODO Auto-generated method stub
		return null;
	}

}
