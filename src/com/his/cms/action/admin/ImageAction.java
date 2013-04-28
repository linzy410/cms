package com.his.cms.action.admin;

import java.io.File;
import java.util.List;

import com.his.cms.action.BasePageAction;
import com.his.cms.service.ImageService;

public class ImageAction extends BasePageAction {
	
	private static final long serialVersionUID = -4848248679889814408L;
	private ImageService imageService;
	/** 文件对象 */
	private List<File> Filedata; // uploadify必须使用此变量名称
	/** 文件名 */
	private List<String> FiledataFileName;
	/** 文件内容类型 */
	private List<String> FiledataContentType;
	private int type;

	public String execute() throws Exception {
		imageService.saveImage(Filedata, FiledataFileName, type, super.getLang());
		return JSON;
	}
	
	/**
	 * 图片空间
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		page = imageService.getPage(super.getLang(), pageNo, pageSize);
		return "list";
	}
	
	public List<File> getFiledata() {
		return Filedata;
	}

	public void setFiledata(List<File> filedata) {
		Filedata = filedata;
	}

	public List<String> getFiledataFileName() {
		return FiledataFileName;
	}

	public void setFiledataFileName(List<String> filedataFileName) {
		FiledataFileName = filedataFileName;
	}

	public List<String> getFiledataContentType() {
		return FiledataContentType;
	}

	public void setFiledataContentType(List<String> filedataContentType) {
		FiledataContentType = filedataContentType;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	/* (non-Javadoc)
	 * @see com.his.cms.action.BasePageAction#getMenuTag()
	 */
	@Override
	protected String getMenuTag() {
		return "image";
	}

}
