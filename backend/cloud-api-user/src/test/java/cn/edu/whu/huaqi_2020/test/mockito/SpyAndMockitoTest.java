package cn.edu.whu.huaqi_2020.test.mockito;

import cn.edu.whu.huaqi_2020.test.BaseTest;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/11/7 11:17
 **/
//TODO 1.spy and mock fail 2.fail when maven build
public class SpyAndMockitoTest extends BaseTest {

    @Spy
    private SpyAndMock spyAndMock;

    //在调用方法的第一层截断依赖
//    @Mock
//    private SpyAndMock spyAndMock;

//    @Test
//    public void test(){
//        when(spyAndMock.sumPublic(1, 2)).thenReturn(5);
//        Assert.assertEquals(3,spyAndMock.sumPublic(1,2));
//    }
}
