package com.his.cms.action.admin;

import java.io.File;
import java.util.List;

import com.his.cms.action.BaseAction;
import com.his.cms.service.UploadFileService;

public class UploadAction extends BaseAction {
	
	private static final long serialVersionUID = -4848248679889814408L;
	private UploadFileService uploadFileService;
	/** �ļ����� */
	private List<File> Filedata; // uploadify����ʹ�ô˱�������
	/** �ļ��� */
	private List<String> FiledataFileName;
	/** �ļ��������� */
	private List<String> FiledataContentType;
	private int type;

	public String execute() throws Exception {
		uploadFileService.saveUploadFile(Filedata, FiledataFileName, 0);
		return JSON;
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

	public void setUploadFileService(UploadFileService uploadFileService) {
		this.uploadFileService = uploadFileService;
	}

}
