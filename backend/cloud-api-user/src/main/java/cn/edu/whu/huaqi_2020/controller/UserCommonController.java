package cn.edu.whu.huaqi_2020.controller;

import cc.eamon.open.error.Assert;
import cc.eamon.open.status.Status;
import cc.eamon.open.status.StatusException;
import cn.edu.whu.huaqi_2020.entities.user.User;
import cn.edu.whu.huaqi_2020.service.impl.UserCommonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Api(
        value = "用户公共模块",
        tags = "用户公共模块"
)
@RestController
@RequestMapping({"api/user/common"})
public class UserCommonController {

    @Autowired
    private UserCommonService userCommonService;


    @RequestMapping(
            value = "login",
            method = RequestMethod.GET
    )
    @Transactional
    @ResponseBody
    public Map<String, Object> login(@RequestParam String account, @RequestParam String password) {
        return this.loginUser(account, password);
    }

    private Map<String, Object> loginUser(String account, String password) {

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        Assert.notNull(response, "AUTH_ERROR");

        try {
            Map<String, Object> userMap = this.userCommonService.login(account, password);
            response.setHeader("token", userMap.get("token").toString());
            response.setHeader("userId", userMap.get("id").toString());
            Cookie cookie = new Cookie("token", userMap.get("token").toString());
            Cookie cookieUser = new Cookie("userId", userMap.get("id").toString());
            cookie.setPath("/");
            cookieUser.setPath("/");
            response.addCookie(cookie);
            response.addCookie(cookieUser);

            return Status.successBuilder().addDataValue(userMap).map();
        } catch (Exception e) {
            throw new StatusException("AUTH_ERROR");
        }
    }

    @RequestMapping(
            value = "register",
            method = RequestMethod.POST
    )
    @Transactional
    @ResponseBody
    public Map<String, Object> register(@RequestBody User registerMapper) {
        this.userCommonService.register(registerMapper);
        return this.loginUser(registerMapper.getNickName(), registerMapper.getPassword());
    }

}
