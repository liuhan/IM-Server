package com.longlian.dao;

import com.longlian.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(java.lang.Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(java.lang.Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByToken(String token);
}