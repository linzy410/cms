package com.his.cms.action.admin;

import java.io.File;
import java.util.List;

import com.his.cms.action.BasePageAction;
import com.his.cms.service.ImageService;

public class ImageAction extends BasePageAction {
	
	private static final long serialVersionUID = -4848248679889814408L;
	private ImageService imageService;
	/** �ļ����� */
	private List<File> Filedata; // uploadify����ʹ�ô˱�������
	/** �ļ��� */
	private List<String> FiledataFileName;
	/** �ļ��������� */
	private List<String> FiledataContentType;
	private int type;

	public String execute() throws Exception {
		imageService.saveImage(Filedata, FiledataFileName, type, super.getLang());
		return JSON;
	}
	
	/**
	 * ͼƬ�ռ�
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
