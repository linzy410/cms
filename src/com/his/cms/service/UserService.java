package com.his.cms.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.his.cms.dao.UserDao;
import com.his.cms.dto.UpdateMap;
import com.his.cms.model.User;
import com.his.cms.util.SessionUtil;

public class UserService {
	
	private UserDao userDao;

	public List<User> getUserList() {
		return userDao.findUserList();
	}
	
	public boolean login(String username, String password, HttpServletRequest request) {
		User user = userDao.findUserByUsernameAndPassword(username, password);
		if (user == null) {
			return false;
		}
		SessionUtil.setUserSession(user, request);
		return true;
	}
	
	public User getUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}
	
	public void saveUser(User user) {
		userDao.addUser(user);
	}
	
	public User getUserById(int id) {
		return userDao.findUser(id);
	}
	
	public void removeUser(int id) {
		userDao.deleteUser(id);
	}
	
	public void updateUser(User user) {
		UpdateMap updateMap = new UpdateMap("User");
		updateMap.addField("name", user.getName());
		updateMap.addField("password", user.getPassword());
		updateMap.addWhere("id", user.getId());
		userDao.update(updateMap);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
