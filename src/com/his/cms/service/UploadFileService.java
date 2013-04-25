/* 
 * Created by linzheyan at 2012-11-29 
 * Copyright HiSupplier.com 
 */

package com.his.cms.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;

import com.his.cms.dao.UploadFileDao;
import com.his.cms.model.UploadFile;
import com.his.cms.util.IConstants;
import com.his.cms.util.PropertiesUtil;

/**
 * @author linzheyan
 *
 * 2012-11-29
 */
public class UploadFileService {
	
	private UploadFileDao uploadFileDao;
	
	/**
	 * 根据文件类型查找上传文件
	 * @param type
	 * @return
	 */
	public List<UploadFile> getUploadFileList(int type) {
		return uploadFileDao.findListByType(type);
	}
	
	/**
	 * 保存上传的文件
	 * @param files
	 * @throws IOException 
	 */
	public void saveUploadFile(List<File> files, List<String> fileNames, int imageType) throws IOException {
		String datePath = new SimpleDateFormat("yyyyMMdd").format(new Date());
		File uploadFolder = new File(PropertiesUtil.getString(IConstants.KEY_FILE_UPLOAD_SAVE_PATH) + "/" + datePath);
		if (!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}
		List<UploadFile> uploadFiles = new ArrayList<UploadFile>();
		for (int i = 0; i < files.size(); i++) {
			String extension = fileNames.get(i).substring(fileNames.get(i).lastIndexOf("."));
			String targetFilename = new SimpleDateFormat("HHmmsssssss").format(new Date());
			targetFilename = checkFilenameUnique(uploadFolder.getAbsolutePath(), targetFilename, extension);
			File target = new File(uploadFolder.getAbsolutePath() + "/" + targetFilename);
			FileUtils.copyFile(files.get(i), target);
			UploadFile uploadFile = new UploadFile();
			uploadFile.setFileName(targetFilename);
			uploadFile.setFilePath(datePath);
			uploadFile.setType(imageType);
			uploadFile.setUploadName(fileNames.get(i));
			uploadFile.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			uploadFiles.add(uploadFile);
		}
		uploadFileDao.batchAdd(uploadFiles);
	}
	
	/**
	 * 
	 * @param filename  文件名前辍(除扩展名部分)
	 * @param extension 扩展名
	 * @return
	 */
	private String checkFilenameUnique(String dir, String filename, String extension) {
		File file = new File(dir + "/" + filename + extension);
		if (file.exists()) {
			filename += new Random().nextInt(1000);
			return checkFilenameUnique(dir, filename, extension);
		}
		return filename + extension;
	}

	public void setUploadFileDao(UploadFileDao uploadFileDao) {
		this.uploadFileDao = uploadFileDao;
	}
}
