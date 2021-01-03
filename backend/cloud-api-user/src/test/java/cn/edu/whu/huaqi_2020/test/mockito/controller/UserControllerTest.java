package cn.edu.whu.huaqi_2020.test.mockito.controller;

import cn.edu.whu.huaqi_2020.service.impl.UserService;
import cn.edu.whu.huaqi_2020.util.UtilsAndCommons;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/12/17 19:27
 **/
public class UserControllerTest extends ControllerBaseTest {

    private String test = null;

    private Map<String, Object> returnMap = new HashMap<>();


//    @Test
//    public void testFetchUser() throws Exception{
//        returnMap.put("fetchUser","ok");
//        //stub
//        Mockito.when(userService.selectByPrimaryKey(TEST_USER_ID)).thenReturn(returnMap);
//        //构造虚拟的http请求
//        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(UtilsAndCommons.USER_CONTEXT)
//                .param("id",TEST_USER_ID);
//        //发送请求
//        test = mockMvc.perform(builder).andReturn().getResponse().getContentAsString();
//    }
//
//    @Test(dependsOnMethods = "testFetchUser")
//    public void test2(){
//        System.out.println(test);
//    }
}
