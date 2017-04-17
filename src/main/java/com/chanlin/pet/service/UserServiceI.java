package com.chanlin.pet.service;

import com.chanlin.pet.model.User;

public interface UserServiceI {
	public User getUserById(int id);
	public User login();
	public int addUser(User user);
<<<<<<< HEAD
	public int updatePwd(String mobile, String password);
=======
>>>>>>> 80053dc6d030b5dfde746ab7878b935ca475c531
}
