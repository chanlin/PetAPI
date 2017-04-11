package com.chanlin.pet.dao;

import com.chanlin.pet.model.PetType;

public interface PetTypeMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(PetType record);

    int insertSelective(PetType record);

    PetType selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(PetType record);

    int updateByPrimaryKey(PetType record);
}