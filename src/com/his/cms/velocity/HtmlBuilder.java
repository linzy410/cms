/* 
 * Created by linzheyan at 2011-12-26 
 * Copyright HiSupplier.com 
 */

package com.his.cms.velocity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.his.cms.service.MenuService;
import com.his.cms.util.Global;
import com.his.cms.util.IConstants;


/**
 * @author linzheyan
 *
 * 2011-12-26
 */
public abstract class HtmlBuilder {
	
	private MenuService menuService = (MenuService) Global.getBean("menuService");

	/**
	 * 构造文件
	 * @return
	 * @throws Exception
	 */
	public boolean builder() throws Exception {
		Properties prop = new Properties();
		prop.put("file.resource.loader.path", IConstants.VELOCITY_VM_DIR);
		prop.put("runtime.log", IConstants.VELOCITY_RUNTIME_LOG_FILE_DIR);
		// HtmlBuilder.class.getClassLoader().getResource("velocity.properties").getPath()
		Velocity.init(prop);
		Template template = Velocity.getTemplate(getVmName(), "utf-8");
		Map<String, VelocityContext> contextMap = getContextMap();
		if (contextMap == null || contextMap.isEmpty() || contextMap.keySet() == null || contextMap.keySet().isEmpty()) {
			return false;
		}
		Set<String> keySet = contextMap.keySet();
		for (String filename : keySet) {
			VelocityContext context = (VelocityContext) contextMap.get(filename);
			if (context != null) {
				context.put("activeMenuId", getActiveMenuId());
				context.put("menus", menuService.getMenuListByType(0));
				buildFiles(template, context, filename);
			}
		}
		contextMap = null;
		return true;
	}
	
	protected abstract Map<String, VelocityContext> getContextMap() throws SQLException;
	
	/**
	 * 文件相对路径，含前/,不含后/
	 * @return
	 */
	protected abstract String getFileOutPath();
	protected abstract String getVmName();
	protected abstract int getActiveMenuId();

	/**
	 * 文件输出
	 * @param template
	 * @param context
	 * @param outputFileName 输出的文件名称
	 * @throws IOException
	 */
	protected void buildFiles(Template template, VelocityContext context, String outputFileName) throws IOException {
		Writer writer = null;
		try {
			File outPath = new File(IConstants.VELOCITY_OUTPUT_DIR + IConstants.SLASH + getFileOutPath());
			if (!outPath.exists()) {
				outPath.mkdirs();
			}
			File outFile = new File(outPath, outputFileName);
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
			template.merge(context, writer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (Exception e) {
			}
		}
	}
}
