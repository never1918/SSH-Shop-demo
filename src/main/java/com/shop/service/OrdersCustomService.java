package com.shop.service;

import java.util.List;

import com.shop.model.Orders;
import com.shop.model.OrdersCustom;
import com.shop.model.User;


public interface OrdersCustomService {

	public List<OrdersCustom> findOrdersUser() throws Exception;

	public List<Orders> findOrdersUserResultMap() throws Exception;

	public List<Orders> findOrdersAndOrderDetailsResultMap() throws Exception;

	public List<User> findUserAndItemsResultMap() throws Exception;
}
