package cn.edu.whu.huaqi_2020.test;

import org.junit.Test;

import java.time.Instant;
import java.util.Date;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/11/2 19:35
 **/
public class DateTest {

    @Test
    public void test(){
        System.out.println(Date.from(Instant.now()));
    }
}
