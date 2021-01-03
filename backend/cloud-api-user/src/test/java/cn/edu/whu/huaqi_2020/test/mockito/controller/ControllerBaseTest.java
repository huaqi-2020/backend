package cn.edu.whu.huaqi_2020.test.mockito.controller;

import cn.edu.whu.huaqi_2020.service.impl.UserService;
import cn.edu.whu.huaqi_2020.test.BaseTest;
import cn.edu.whu.huaqi_2020.util.UtilsAndCommons;
import cn.edu.whu.huaqi_2020.web.controller.UserController;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/11/7 11:46
 **/
//拿到Servlet虚拟上下文
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
@Test(groups = "user_controller-test")
public class ControllerBaseTest extends BaseTest {

    protected static final String TEST_USER_ID = "123";

    //模拟执行mvc操作（执行http请求）
    protected MockMvc mockMvc;

    //注入虚拟上下文中特定的Controller
    //并注入依赖的Mock对象
    @InjectMocks
    private UserController userController;

    //公共mock
    @Mock
    protected UserService userService;

    @BeforeTest
    public void before(){
        //mockMvc == servlet(TestDispatcherServlet)
        //mapping handler基于此controller
        super.before();
        mockInjectUserService();
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    //Mock Spring Inject
    protected void mockInjectUserService(){
        Mockito.doReturn(userService).when(context).getBean(UserService.class);
    }

}
