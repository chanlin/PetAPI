package com.chanlin.pet.dao;

import com.chanlin.pet.model.Breed;

public interface BreedMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(Breed record);

    int insertSelective(Breed record);

    Breed selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(Breed record);

    int updateByPrimaryKey(Breed record);
}