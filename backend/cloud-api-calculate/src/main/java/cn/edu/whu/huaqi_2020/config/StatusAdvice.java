package cn.edu.whu.huaqi_2020.config;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/26 16:05
 **/
@ControllerAdvice
public class StatusAdvice extends cc.eamon.open.status.StatusAdvice {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

    /**
     * 全局异常处理
     */
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    @Override
    public Map<String, Object> statusExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        return super.statusExceptionHandler(request, response, e);
    }

    @Override
    public boolean setResponseStatus() {
        return true;
    }
}
