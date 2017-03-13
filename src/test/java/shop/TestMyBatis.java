package shop;

import java.util.List;  

import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
  






import com.alibaba.fastjson.JSON;  
import com.shop.model.Orders;
import com.shop.model.OrdersCustom;
import com.shop.model.User;
import com.shop.service.OrdersCustomService;
import com.shop.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:spring.xml",  
        "classpath:spring-mybatis.xml" })  
public class TestMyBatis {  
  
    private static final Logger LOGGER = Logger  
            .getLogger(TestMyBatis.class);  
  
    @Autowired  
    private UserService userService; 
    @Autowired
    private OrdersCustomService orderscustomService;
      
    @Test  
    public void testQueryById1() {  
        User userInfo = userService.getUserById(3);  
        LOGGER.info(JSON.toJSON(userInfo));  
    }  
  
    @Test  
    public void testQueryAll() {  
        List<User> userInfos = userService.getuser();  
        LOGGER.info(JSON.toJSON(userInfos));  
    }  
    
    @Test
    public void testFindOrdersUser() throws Exception{
    	List<OrdersCustom> orderscutomInfos = orderscustomService.findOrdersUser();
    	LOGGER.info(JSON.toJSON(orderscutomInfos));
    }
    
    @Test
    public void testFindOrdersUserResultMap() throws Exception{
    	List<Orders> ordersInfos = orderscustomService.findOrdersUserResultMap();
    	LOGGER.info(JSON.toJSON(ordersInfos));
    }
    
    @Test
    public void testfindOrdersAndOrderDetailsResultMap() throws Exception{
    	List<Orders> OrdersAndOrderDetailsInfos = orderscustomService.findOrdersAndOrderDetailsResultMap();
    	LOGGER.info(JSON.toJSON(OrdersAndOrderDetailsInfos));
    }
    
    @Test
    public void testfindUserAndItemsResultMap() throws Exception{
    	List<User> findUserAndItemsResultMap = orderscustomService.findUserAndItemsResultMap();
    	LOGGER.info(JSON.toJSON(findUserAndItemsResultMap));
    }
}  
