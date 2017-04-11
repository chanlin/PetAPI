package com.chanlin.pet.dao;

import com.chanlin.pet.model.Platts;

public interface PlattsMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Platts record);

    int insertSelective(Platts record);

    Platts selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Platts record);

    int updateByPrimaryKey(Platts record);
}