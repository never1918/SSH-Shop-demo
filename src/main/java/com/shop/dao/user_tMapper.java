package com.shop.dao;

import com.shop.model.user_t;

public interface user_tMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(user_t record);

    int insertSelective(user_t record);

    user_t selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(user_t record);

    int updateByPrimaryKey(user_t record);
}