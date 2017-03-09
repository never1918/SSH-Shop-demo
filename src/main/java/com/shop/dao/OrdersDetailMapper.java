package com.shop.dao;

import com.shop.model.OrdersDetail;

public interface OrdersDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrdersDetail record);

    int insertSelective(OrdersDetail record);

    OrdersDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrdersDetail record);

    int updateByPrimaryKey(OrdersDetail record);
}