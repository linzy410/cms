/* 
 * Created by linzheyan at 2012-11-29 
 * Copyright HiSupplier.com 
 */

package com.his.cms.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;

import com.his.cms.model.UploadFile;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * @author linzheyan
 *
 * 2012-11-29
 */
public class UploadFileDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<UploadFile> findListByType(int type) {
		return super.getSqlMapClientTemplate().queryForList("upload.findListByType", type);
	}

	public int batchAdd(final List<UploadFile> uploadFiles) {
		return (Integer) getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				executor.startBatch();
				for (UploadFile file : uploadFiles) {
					executor.insert("upload.addUploadFile", file);
				}
				return executor.executeBatch();
			}
		});
	}
}
