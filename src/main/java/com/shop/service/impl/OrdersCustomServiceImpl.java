package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.OrdersMapperCustom;
import com.shop.model.Orders;
import com.shop.model.OrdersCustom;
import com.shop.model.User;
import com.shop.service.OrdersCustomService;

@Service("OrdersCustomService")  
public class OrdersCustomServiceImpl implements OrdersCustomService {  
    @Resource  
    private OrdersMapperCustom OrdersMapperCustomDao;  

	@Override
	public List<OrdersCustom> findOrdersUser() throws Exception {
		return OrdersMapperCustomDao.findOrdersUser();
	}

	@Override
	public List<Orders> findOrdersUserResultMap() throws Exception {
		return OrdersMapperCustomDao.findOrdersUserResultMap();
	}

	@Override
	public List<Orders> findOrdersAndOrderDetailsResultMap() throws Exception {
		return OrdersMapperCustomDao.findOrdersAndOrderDetailsResultMap();
	}

	@Override
	public List<User> findUserAndItemsResultMap() throws Exception {
		return OrdersMapperCustomDao.findUserAndItemsResultMap();
	}  
  
}  
