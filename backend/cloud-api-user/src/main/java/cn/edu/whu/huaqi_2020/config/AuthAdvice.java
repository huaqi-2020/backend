package cn.edu.whu.huaqi_2020.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/26 15:51
 **/
@Aspect
@Component
public class AuthAdvice extends cc.eamon.open.auth.advice.AuthAdvice {


    @Override
    public boolean open(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }


    @Override
    public boolean checkGroup(HttpServletRequest request, HttpServletResponse response, String uri, String group) {
        return "super".equals(group) || "admin".equals(group);
    }
}
