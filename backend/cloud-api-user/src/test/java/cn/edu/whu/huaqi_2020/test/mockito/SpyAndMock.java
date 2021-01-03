package cn.edu.whu.huaqi_2020.test.mockito;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/11/7 11:15
 **/
public class SpyAndMock {

    private int sumPrivate(int x, int y){
        return x + y;
    }

    public int sumPublic(int x, int y){
        return sumPrivate(x, y);
    }
}
