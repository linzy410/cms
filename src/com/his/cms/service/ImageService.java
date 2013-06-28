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
	public Page getPage(int type, int lang, int pageNo, int pageSize) {
		List<Image> images = imageDao.findImageList(type, lang, pageNo, pageSize);
		int total = imageDao.findCountImage(type, lang);
		Page page = new Page(images, total, pageSize);
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
	public void saveImage(List<File> files, List<String> fileNames, int imageType, int lang, String creator, String createTime) throws IOException {
		String datePath = new SimpleDateFormat("yyyyMM").format(new Date());
		// �ļ������ַ
		File uploadFolder = new File(IConstants.FILE_UPLOAD_SAVE_PATH + IConstants.SLASH + datePath); 
		if (!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}
		List<Image> images = new ArrayList<Image>();
		for (int i = 0; i < files.size(); i++) {
//			String extension = fileNames.get(i).substring(fileNames.get(i).lastIndexOf("."));
//			String targetFilename = new SimpleDateFormat("HHmmsssssss").format(new Date());
//			targetFilename = checkFilenameUnique(uploadFolder.getAbsolutePath(), targetFilename, extension);
//			File target = new File(uploadFolder.getAbsolutePath() + IConstants.SLASH + targetFilename);
//			FileUtils.copyFile(files.get(i), target);
//			Image image = new Image();
//			image.setSaveFile(datePath + IConstants.SLASH + targetFilename);
//			image.setType(imageType);
//			image.setLang(lang);
//			image.setName(fileNames.get(i));
//			image.setCreator(creator);
//			image.setCreateTime(createTime);
			Image image = saveImage(files.get(i), fileNames.get(i), imageType, lang, creator, createTime, datePath, uploadFolder);
			images.add(image);
		}
		imageDao.batchAdd(images);
	}
	
	public Image saveImage(File file, String fileName, int imageType, int lang, String creator, String createTime) throws IOException {
		String datePath = new SimpleDateFormat("yyyyMM").format(new Date());
		File uploadFolder = new File(IConstants.FILE_UPLOAD_SAVE_PATH + IConstants.SLASH + datePath); 
		if (!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}
		Image image = saveImage(file, fileName, imageType, lang, creator, createTime, datePath, uploadFolder);
		int imgId = imageDao.addImage(image);
		image.setId(imgId);
		return image;
	}

	private Image saveImage(File file, String fileName, int imageType, int lang, String creator, String createTime, String datePath, File uploadFolder) throws IOException {
		String extension = fileName.substring(fileName.lastIndexOf("."));
		String targetFilename = new SimpleDateFormat("ddHHmmsssss").format(new Date());
		targetFilename = checkFilenameUnique(uploadFolder.getAbsolutePath(), targetFilename, extension);
		File target = new File(uploadFolder.getAbsolutePath() + IConstants.SLASH + targetFilename);
		FileUtils.copyFile(file, target);
		Image image = new Image();
		image.setSaveFile(datePath + IConstants.SLASH + targetFilename);
		image.setType(imageType);
		image.setLang(lang);
		image.setName(fileName);
		image.setCreator(creator);
		image.setCreateTime(createTime);
		return image;
	}
	
	/**
	 * ȷ���ļ������ظ�
	 * @param dir 		�ļ����������ַ
	 * @param filename  �ļ���ǰ�(����չ������)
	 * @param extension ��չ��
	 * @return
	 */
	private String checkFilenameUnique(String dir, String filename, String extension) {
		File file = new File(dir + IConstants.SLASH + filename + extension);
		if (file.exists()) {
			filename += new Random().nextInt(1000);
			return checkFilenameUnique(dir, filename, extension);
		}
		return filename + extension;
	}
	
	public void removeImage(String imageIds) {
		List<Image> images = imageDao.findImageByIds(imageIds);
		File file = null;
		for (Image img : images) {
			file = new File(IConstants.FILE_UPLOAD_SAVE_PATH + IConstants.SLASH + img.getSaveFile()); 
			file.delete();
		}
		imageDao.deleteImageByIds(imageIds);
	}
	
	/**
	 * ͼƬ�ռ��ͼƬ����
	 * @param lang
	 * @return
	 */
	public int getImageSpaceAllCount(int lang) {
		return imageDao.findCountImage(IConstants.IMAGE_TYPE_SPACE, lang);
	}

	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}
}
