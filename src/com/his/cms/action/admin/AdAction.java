/* 
 * Created by linzheyan at 2013-5-7 
 * Copyright HiSupplier.com 
 */

package com.his.cms.action.admin;

import java.util.List;

import com.his.cms.action.BasePageAction;
import com.his.cms.model.Ad;
import com.his.cms.service.AdService;
import com.his.cms.util.IConstants;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author linzheyan
 *
 * 2013-5-7
 */
public class AdAction extends BasePageAction implements ModelDriven<Ad> {
	
	private static final long serialVersionUID = 2727358350030173051L;
	private AdService adService;
	private List<Ad> adList;
	private Ad ad = new Ad();
	
	
	public String list() throws Exception {
		adList = adService.getAdList(IConstants.AD_TYPE_BANNER);
		return "list";
	}
	
	public String input() throws Exception{
		return INPUT;
	}
	
	public String save() throws Exception {
		ad.setCreateTime(super.getCurrentTime());
		ad.setCreator(super.getCreator());
		adService.saveAd(ad);
		return LISTACTION;
	}
	
	public String edit() throws Exception{
		ad = adService.getAdById(selectedId);
		return "input";
	}
	
	public String update() throws Exception {
		adService.updateAd(ad);
		return LISTACTION;
	}
	
	public String remove() throws Exception {
		adService.removeAd(selectedId);
		return LISTACTION;
	}

	@Override
	protected String getMenuTag() {
		return "ad";
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	public Ad getModel() {
		return ad;
	}

	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

	public void setAdService(AdService adService) {
		this.adService = adService;
	}

	public List<Ad> getAdList() {
		return adList;
	}
}
