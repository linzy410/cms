/* 
 * Created by linzheyan at 2012-11-29 
 * Copyright HiSupplier.com 
 */

package com.his.cms.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.his.cms.dto.UpdateMap;


/**
 * @author linzheyan
 *
 * 2012-11-29
 */
public abstract class BaseDao extends SqlMapClientDaoSupport  {

	public int update(UpdateMap updateMap) {
		return this.getSqlMapClientTemplate().update("common.update", updateMap);
	}
	
	public int delete(UpdateMap updateMap) {
		return this.getSqlMapClientTemplate().update("common.delete", updateMap);
	}

}
