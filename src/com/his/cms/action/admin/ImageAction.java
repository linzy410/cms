package com.his.cms.action.admin;

import com.his.cms.action.BasePageAction;
import com.his.cms.service.ImageService;

public class ImageAction extends BasePageAction {
	
	private static final long serialVersionUID = -4848248679889814408L;
	private ImageService imageService;
	
	/**
	 * Í¼Æ¬¿Õ¼ä
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		page = imageService.getPage(super.getLang(), pageNo, 12);
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
	protected String getMenuTag() {
		return "image";
	}

}
