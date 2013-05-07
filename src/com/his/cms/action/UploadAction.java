/* 
 * Created by linzheyan at 2013-5-6 
 * Copyright HiSupplier.com 
 */

package com.his.cms.action;

import java.io.File;
import java.util.List;

import com.his.cms.model.Image;
import com.his.cms.service.ImageService;

/**
 * @author linzheyan
 *
 * 2013-5-6
 */
public class UploadAction extends BaseAction {

	private static final long serialVersionUID = -697202474003248211L;
	
	private ImageService imageService;
	/** 文件对象 */
	private List<File> Filedata; // uploadify必须使用此变量名称
	/** 文件名 */
	private List<String> FiledataFileName;
	/** 文件内容类型 */
	private List<String> FiledataContentType;
	private int type;
	private Image image;

	public String execute() throws Exception {
		imageService.saveImage(Filedata, FiledataFileName, type, super.getLang(), super.getCreator(), super.getCurrentTime());
		return null;
	}
	
	/**
	 * 单个图片上传
	 * @return
	 * @throws Exception
	 */
	public String single_image() throws Exception {
		setImage(imageService.saveImage(Filedata.get(0), FiledataFileName.get(0), type, super.getLang(), super.getCreator(), super.getCurrentTime()));
		return JSON;
	}

	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Image getImage() {
		return image;
	}
}
