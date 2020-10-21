package cn.edu.whu.huaqi_2020.test;

import cn.edu.whu.huaqi_2020.entities.user.User;
import org.junit.Test;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/21 10:47
 **/
public class UserTest {

    @Test
    public void testModifyPassword(){
        User user = new User();
        user.setPassword("啦啦啦");
        System.out.println(user.modifyPassword(user.modifyPassword(user.getPassword())));
    }

}
