package com.his.cms.dao;

import java.util.List;

import com.his.cms.model.User;

public class UserDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<User> findUserList() {
		return super.getSqlMapClientTemplate().queryForList("user.findUserList");
	}
	
	public User findUser(int id) {
		return (User) super.getSqlMapClientTemplate().queryForObject("user.findUser", id);
	}
	
	public User findUserByUsername(String username) {
		return (User) super.getSqlMapClientTemplate().queryForObject("user.findUserByUsername", username);
	}
	
	public void addUser(User user) {
		super.getSqlMapClientTemplate().insert("user.addUser", user);
	}
	
	public void deleteUser(int id) {
		super.getSqlMapClientTemplate().delete("user.deleteUser", id);
	}
}
