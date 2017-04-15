package com.chanlin.pet.service;

import com.chanlin.pet.model.User;

public interface UserServiceI {
	public User getUserById(int id);
	public User login();
	public int addUser(User user);
	public int updatePwd(String mobile, String password);
}
