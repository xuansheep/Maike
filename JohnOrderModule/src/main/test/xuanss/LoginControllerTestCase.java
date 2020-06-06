package xuanss;

import com.john.order.JohnOrderModuleApplication;
import com.john.order.domain.dto.UserDTO;
import com.john.order.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xuhang
 * @date 2020/6/6 14:08
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JohnOrderModuleApplication.class)
public class LoginControllerTestCase {

    @Autowired
    UserService userService;

    @Test
    public void mainTest(){
        System.out.println("ok");
    }


    @Test
    public void saveUser(){
        UserDTO user = new UserDTO();
        user.setUsername("xuhang");
        user.setPassword("123456");
        userService.saveUser(user);
    }

    @Test
    public void login(){
        boolean b = userService.login("xuhang", "123456");
    }

}
