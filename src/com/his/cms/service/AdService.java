/**
 * 
 */
package com.his.cms.service;

import java.util.List;

import com.his.cms.dao.AdDao;
import com.his.cms.dto.UpdateMap;
import com.his.cms.model.Ad;
import com.his.cms.util.IConstants;

/**
 * @author 林哲炎
 *
 * creat in 2013-4-21
 */
public class AdService {
	
	private AdDao adDao;
	
	/**
	 * 展示中的菜单
	 * @return
	 */
	public List<Ad> getShowAdList() {
		return adDao.findShowAdList();
	}

	/**
	 * 根据类型查找
	 * @param type
	 * @return
	 */
	public List<Ad> getAdList(int type) {
		return adDao.findAdList(type);
	}
	
	public Ad getAdById(int id) {
		return adDao.findAd(id);
	}
	
	public void saveAd(Ad ad) {
		ad.setType(IConstants.AD_TYPE_BANNER);
		adDao.addAd(ad);
	}
	
	public void updateAd(Ad ad) {
		UpdateMap updateMap = new UpdateMap("Ad");
		updateMap.addField("title", ad.getTitle());
		updateMap.addField("imgId", ad.getImgId());
		updateMap.addWhere("id", ad.getId());
		adDao.update(updateMap);
	}
	
	public void removeAd(int id) {
		adDao.deleteAd(id);
	}
	
	public void setAdDao(AdDao adDao) {
		this.adDao = adDao;
	}
}
