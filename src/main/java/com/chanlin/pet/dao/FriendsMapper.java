package com.chanlin.pet.dao;

import com.chanlin.pet.model.Friends;

public interface FriendsMapper {
    int deleteByPrimaryKey(Integer fId);

    int insert(Friends record);

    int insertSelective(Friends record);

    Friends selectByPrimaryKey(Integer fId);

    int updateByPrimaryKeySelective(Friends record);

    int updateByPrimaryKey(Friends record);
}