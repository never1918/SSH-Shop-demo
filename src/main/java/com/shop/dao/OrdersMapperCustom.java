package com.shop.dao;

import java.util.List;

import com.shop.model.OrdersCustom;

/**
 * @author Jeff E-mail:Jeff@ProTest.com
 * @version 创建时间：2017年3月13日 下午8:24:49
 * 类说明
 * 订单mapper
 */
public interface OrdersMapperCustom {
	public List<OrdersCustom> findOrdersUser()throws Exception;
}
