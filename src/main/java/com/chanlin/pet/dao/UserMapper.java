package com.chanlin.pet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chanlin.pet.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	int updatePwdByPhone(@Param("uPhone")String uPhone, @Param("uPassword")String uPassword);

	List<User> getUserList(String user_id);
}