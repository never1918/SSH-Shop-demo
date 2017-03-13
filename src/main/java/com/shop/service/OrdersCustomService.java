package com.shop.service;

import java.util.List;

import com.shop.model.OrdersCustom;


public interface OrdersCustomService {

	public List<OrdersCustom> findOrdersUser() throws Exception;
}
