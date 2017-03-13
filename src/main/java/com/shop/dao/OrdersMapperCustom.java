package com.shop.dao;

import java.util.List;

import com.shop.model.Orders;
import com.shop.model.OrdersCustom;
import com.shop.model.User;

/**
 * @author Jeff E-mail:Jeff@ProTest.com
 * @version 创建时间：2017年3月13日 下午8:24:49
 * 类说明
 * 订单mapper
 */
public interface OrdersMapperCustom {
	//查询用户信息
	public List<OrdersCustom> findOrdersUser()throws Exception;
	//查询用户信息resultMap
	public List<Orders> findOrdersUserResultMap()throws Exception;
	//查询订单（关联用户）和订单明细
	public List<Orders> findOrdersAndOrderDetailsResultMap()throws Exception;
	//查询用户购买商品信息
	public List<User> findUserAndItemsResultMap()throws Exception;
}
