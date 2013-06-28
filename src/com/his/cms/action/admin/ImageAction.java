package com.his.cms.action.admin;

import com.his.cms.action.BasePageAction;
import com.his.cms.service.ImageService;
import com.his.cms.util.IConstants;

public class ImageAction extends BasePageAction {
	
	private static final long serialVersionUID = -4848248679889814408L;
	private ImageService imageService;
	private int type;
	
	/**
	 * Í¼Æ¬¿Õ¼ä
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		if (type == 0)
			type = IConstants.IMAGE_TYPE_SPACE;
		page = imageService.getPage(type, super.getLang(), pageNo, 12);
		return "list";
	}
	
	public String remove() throws Exception {
		imageService.removeImage(selectedIds);
		return LISTACTION;
	}
	
	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	/* (non-Javadoc)
	 * @see com.his.cms.action.BasePageAction#getMenuTag()
	 */
	@Override
	public String getMenuTag() {
		return "image";
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

}
