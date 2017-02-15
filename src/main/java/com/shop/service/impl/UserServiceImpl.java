package com.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.user_tMapper;
import com.shop.model.user_t;
import com.shop.service.IuserService;

@Service("userService")  
public class UserServiceImpl implements IuserService {  
    @Resource  
    private user_tMapper userDao;  
    @Override  
    public user_t getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);  
    }  
  
}  
