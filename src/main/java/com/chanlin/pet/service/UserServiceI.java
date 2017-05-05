package com.chanlin.pet.service;

import java.util.List;

import com.chanlin.pet.model.User;

public interface UserServiceI {
	public User getUserById(int id);
	public User login();
	public int addUser(User user);
	public int updatePwd(String mobile, String password);
	public List<User> getFriendList(String user_id);
}
