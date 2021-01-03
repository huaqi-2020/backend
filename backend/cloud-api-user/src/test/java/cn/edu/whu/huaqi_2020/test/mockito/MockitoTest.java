package cn.edu.whu.huaqi_2020.test.mockito;

import org.mockito.InOrder;
import org.testng.annotations.Test;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/11/6 23:12
 **/
public class MockitoTest {

    @Test
    public void test(){
        //list is a mock, 记录它的所有操作的一个虚拟对象
        LinkedList list = mock(LinkedList.class);
        list.add(123);
        //验证mock对象是否记录以下操作，以及调用的次数
        verify(list,times(1)).add(123);
    }

    @Test
    public void test2(){
        //list is a mock, 记录它的所有操作的一个虚拟对象
        LinkedList list = mock(LinkedList.class);
        //stub插桩，在某项操作前后插入额外的操作，是完善虚拟对象的过程
        doThrow(new RuntimeException("stub before")).when(list).clear();
        when(list.add(123)).thenReturn(false);
        System.out.println(list.add(123));
    }

    @Test
    public void test3(){
        //list is a mock, 记录它的所有操作的一个虚拟对象
        LinkedList list = mock(LinkedList.class);
        //inOrder对象验证同一个mock对象操作的顺序
        list.add(123);
        list.add(456);
        inOrder(list).verify(list).add(123);
        inOrder(list).verify(list).add(456);

    }

    @Test
    public void test4(){
        //list is a mock, 记录它的所有操作的一个虚拟对象
        LinkedList list1 = mock(LinkedList.class);
        LinkedList list2 = mock(LinkedList.class);
        list2.add(456);
        list1.add(123);
        //验证多个mock对象操作的顺序
        InOrder inOrder = inOrder(list2, list1);
        //false example
        inOrder.verify(list2).add(456);
        inOrder.verify(list1).add(123);

    }

    @Test
    public void test5(){
        //list is a mock, 记录它的所有操作的一个虚拟对象
        LinkedList list1 = mock(LinkedList.class);
        LinkedList list2 = mock(LinkedList.class);
        list1.add(123);
        list1.add(123);
        list2.add(456);
        //验证有无多余操作
        verify(list1,times(2)).add(123);
        verifyNoMoreInteractions(list1);
//        verifyNoInteractions(list2);

    }

    @Test
    public void test6(){
        //list is a mock, 记录它的所有操作的一个虚拟对象
        LinkedList list1 = mock(LinkedList.class);
        when(list1.add(123)).thenReturn(false,true);
        System.out.println(list1.add(123));
        System.out.println(list1.add(123));
    }

}
