package com.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.userMapper;
import com.shop.model.user;
import com.shop.service.IuserService;

@Service("userService")  
public class UserServiceImpl implements IuserService {  
    @Resource  
    private userMapper userDao;  
    @Override  
    public user getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);  
    }  
  
}  
