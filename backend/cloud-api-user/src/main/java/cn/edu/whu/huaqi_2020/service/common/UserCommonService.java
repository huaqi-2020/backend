package cn.edu.whu.huaqi_2020.service.common;

import cn.edu.whu.huaqi_2020.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/23 17:05
 **/
//编写其他非CRUD业务逻辑
@Service
public class UserCommonService {

    @Autowired
    private UserService userService;

}
