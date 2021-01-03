package cn.edu.whu.huaqi_2020.test;

import cn.edu.whu.huaqi_2020.service.impl.UserService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mock.env.MockEnvironment;
import org.testng.annotations.BeforeTest;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/11/7 11:32
 **/
public class BaseTest {

    @Spy
    private MockEnvironment mockEnvironment;

    @Spy
    protected ConfigurableApplicationContext context;

    @BeforeTest
    public void before(){
        try {
            MockitoAnnotations.openMocks(this).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(context.getBeanDefinitionCount());
    }
}
