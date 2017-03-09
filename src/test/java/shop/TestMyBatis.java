package shop;

import java.util.List;  

import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
  



import com.alibaba.fastjson.JSON;  
import com.shop.model.User;
import com.shop.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:spring.xml",  
        "classpath:spring-mybatis.xml" })  
public class TestMyBatis {  
  
    private static final Logger LOGGER = Logger  
            .getLogger(TestMyBatis.class);  
  
    @Autowired  
    private UserService userService;  
  
      
    @Test  
    public void testQueryById1() {  
        User userInfo = userService.getUserById(1);  
        LOGGER.info(JSON.toJSON(userInfo));  
    }  
  
    @Test  
    public void testQueryAll() {  
        List<User> userInfos = userService.getuser();  
        LOGGER.info(JSON.toJSON(userInfos));  
    }  
}  
