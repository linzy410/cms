package com.his.cms.action.admin;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.his.cms.action.BasePageAction;
import com.his.cms.model.User;
import com.his.cms.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends BasePageAction implements ModelDriven<User> {

	private static final long serialVersionUID = -7171118501102029678L;
	private UserService userService;
	private List<User> users;
	private User user = new User();

	public String list() throws Exception {
		users = userService.getUserList();
		return "list";
	}
	
	public String add() throws Exception {
		return INPUT;
	}
	
	public String save() throws  Exception {
		if (hasActionErrors())
			return INPUT;
		user.setCreateTime(super.getCurrentTime());
		userService.saveUser(user);
		return "listAction";
	}
	
	public void validateSave() {
		if (StringUtils.isEmpty(user.getUsername())) 
			addActionError("用户名不能为空");
		if (StringUtils.isEmpty(user.getName())) 
			addActionError("姓名不能为空");
		if (StringUtils.isEmpty(user.getPassword())) 
			addActionError("密码不能为空");
		if (StringUtils.isEmpty(user.getCheckPassword())) 
			addActionError("密码确认不能为空");
		if (!StringUtils.equals(user.getPassword(), user.getCheckPassword()))
			addActionError("两次输入的密码不一致");
		User oldBean = userService.getUserByUsername(user.getUsername());
		if (oldBean != null)
			addActionError("该用户名已存在");
	}
	
	public String edit() throws Exception {
		user = userService.getUserById(selectedId);
		return INPUT;
	}
	
	public String update() throws Exception {
		if (StringUtils.isNotEmpty(user.getPassword()) && !StringUtils.equals(user.getPassword(), user.getCheckPassword())) {
			addActionError("两次输入的密码不一致");
			return INPUT;
		}
		userService.updateUser(user);
		return "listAction";
	}
	
	public String remove() throws Exception {
		userService.removeUser(selectedId);
		return "listAction";
	}
	

	@Override
	protected String getMenuTag() {
		return "user";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public List<User> getUsers() {
		return users;
	}
}
