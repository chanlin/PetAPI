package com.chanlin.pet.dao;

import com.chanlin.pet.model.Pet;

public interface PetMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Pet record);

    int insertSelective(Pet record);

    Pet selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);
}