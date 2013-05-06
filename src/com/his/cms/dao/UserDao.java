package com.his.cms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public User findUserByUsernameAndPassword(String username, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		return (User) super.getSqlMapClientTemplate().queryForObject("user.findUserByUsernameAndPassword", map);
	}
	
	public void addUser(User user) {
		super.getSqlMapClientTemplate().insert("user.addUser", user);
	}
	
	public void deleteUser(int id) {
		super.getSqlMapClientTemplate().delete("user.deleteUser", id);
	}
}
