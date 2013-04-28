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

import com.his.cms.dao.ImageDao;
import com.his.cms.dto.Page;
import com.his.cms.model.Image;
import com.his.cms.util.IConstants;
import com.his.cms.util.PropertiesUtil;

/**
 * @author linzheyan
 *
 * 2012-11-29
 */
public class ImageService {
	
	private ImageDao imageDao;
	
	/**
	 * ͼƬ�ռ�
	 * @param lang
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getPage(int lang, int pageNo, int pageSize) {
		List<Image> images = imageDao.findImageList(IConstants.IMAGE_TYPE_SPACE, lang, pageNo, pageSize);
		int total = imageDao.findCountImage(IConstants.IMAGE_TYPE_SPACE, lang);
		Page page = new Page(images, total);
		page.setUrl("/admin/image_list.action");
		return page;
	}
	
	/**
	 * �����ļ����Ͳ����ϴ��ļ�
	 * @param type
	 * @return
	 */
	public List<Image> getImageList(int type, int lang) {
		return imageDao.findImageListByType(type, lang);
	}
	
	/**
	 * �����ϴ����ļ�
	 * @param files
	 * @throws IOException 
	 */
	public void saveImage(List<File> files, List<String> fileNames, int imageType, int lang) throws IOException {
		String datePath = new SimpleDateFormat("yyyyMMdd").format(new Date());
		File uploadFolder = new File(PropertiesUtil.getString(IConstants.KEY_FILE_UPLOAD_SAVE_PATH) + "/" + datePath);
		if (!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}
		List<Image> images = new ArrayList<Image>();
		for (int i = 0; i < files.size(); i++) {
			String extension = fileNames.get(i).substring(fileNames.get(i).lastIndexOf("."));
			String targetFilename = new SimpleDateFormat("HHmmsssssss").format(new Date());
			targetFilename = checkFilenameUnique(uploadFolder.getAbsolutePath(), targetFilename, extension);
			File target = new File(uploadFolder.getAbsolutePath() + "/" + targetFilename);
			FileUtils.copyFile(files.get(i), target);
			Image image = new Image();
			image.setSaveFile(datePath + "/" + targetFilename);
			image.setType(imageType);
			image.setLang(lang);
			image.setName(fileNames.get(i));
			image.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			images.add(image);
		}
		imageDao.batchAdd(images);
	}
	
	/**
	 * 
	 * @param filename  �ļ���ǰ�(����չ������)
	 * @param extension ��չ��
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

	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}
}