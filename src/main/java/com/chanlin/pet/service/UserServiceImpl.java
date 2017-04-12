package com.chanlin.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanlin.pet.dao.UserMapper;
import com.chanlin.pet.model.User;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	private UserMapper userMapper;
	
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public int addUser(User user){
		int count = userMapper.insertSelective(user);
		return count;
	}
	@Override
	public User login() {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(0);
	}

	@Override
	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

}
