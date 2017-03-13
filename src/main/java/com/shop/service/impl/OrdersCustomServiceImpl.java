package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.OrdersMapperCustom;
import com.shop.model.OrdersCustom;
import com.shop.service.OrdersCustomService;

@Service("OrdersCustomService")  
public class OrdersCustomServiceImpl implements OrdersCustomService {  
    @Resource  
    private OrdersMapperCustom OrdersMapperCustomDao;  

	@Override
	public List<OrdersCustom> findOrdersUser() throws Exception {
		return OrdersMapperCustomDao.findOrdersUser();
	}  
  
}  
