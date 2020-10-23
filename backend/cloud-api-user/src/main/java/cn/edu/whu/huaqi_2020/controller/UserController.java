package cn.edu.whu.huaqi_2020.controller;

import cn.edu.whu.huaqi_2020.service.plus.UserPlusService;
import cn.edu.whu.huaqi_2020.service.impl.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Zhu yuhan
 * Date:2020/9/28 11:14
 **/
@Api(
        value = "用户模块",
        tags = "用户模块"
)
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserPlusService userPlusService;

    @ApiOperation(
            value = "查询用户信息",
            notes = "查询用户信息"
    )
    @RequestMapping(
            value = "info",
            method = RequestMethod.GET
    )
    public Map<String, Object> fetchUser(@RequestParam("id") String id){
        return userService.selectByPrimaryKey(id);
    }

}