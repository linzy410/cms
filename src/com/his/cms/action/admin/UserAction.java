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
			addActionError("�û�������Ϊ��");
		if (StringUtils.isEmpty(user.getName())) 
			addActionError("��������Ϊ��");
		if (StringUtils.isEmpty(user.getPassword())) 
			addActionError("���벻��Ϊ��");
		if (StringUtils.isEmpty(user.getCheckPassword())) 
			addActionError("����ȷ�ϲ���Ϊ��");
		if (!StringUtils.equals(user.getPassword(), user.getCheckPassword()))
			addActionError("������������벻һ��");
		User oldBean = userService.getUserByUsername(user.getUsername());
		if (oldBean != null)
			addActionError("���û����Ѵ���");
	}
	
	public String edit() throws Exception {
		user = userService.getUserById(selectedId);
		return INPUT;
	}
	
	public String update() throws Exception {
		if (StringUtils.isNotEmpty(user.getPassword()) && !StringUtils.equals(user.getPassword(), user.getCheckPassword())) {
			addActionError("������������벻һ��");
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
