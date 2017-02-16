package shop;

import java.util.List;  

import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
  


import com.alibaba.fastjson.JSON;  
import com.shop.model.user;
import com.shop.service.IuserService;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:spring.xml",  
        "classpath:spring-mybatis.xml" })  
public class TestMyBatis {  
  
    private static final Logger LOGGER = Logger  
            .getLogger(TestMyBatis.class);  
  
    @Autowired  
    private IuserService userService;  
  
      
    @Test  
    public void testQueryById1() {  
        user userInfo = userService.getUserById(1);  
        LOGGER.info(JSON.toJSON(userInfo));  
    }  
  
    @Test  
    public void testQueryAll() {  
        List<user> userInfos = userService.getuser();  
        LOGGER.info(JSON.toJSON(userInfos));  
    }  
}  
