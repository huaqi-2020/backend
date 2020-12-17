package cn.edu.whu.huaqi_2020.web.facade.impl;

import cc.eamon.open.status.Status;
import cn.edu.whu.huaqi_2020.dao.dataObject.UserDO;
import cn.edu.whu.huaqi_2020.entities.user.User;
import cn.edu.whu.huaqi_2020.entities.user.UserData;
import cn.edu.whu.huaqi_2020.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/12/10 16:09
 **/
@RestController
@RequestMapping("facade/user")
public class UserFacadeImpl{

    @Autowired
    UserService userService;

    @RequestMapping(
            value = "filter",
            method = RequestMethod.POST
    )
    @Transactional
    public List<Map<String, Object>> getUserFilterMap(User user) {
        return userService.selectByExample(UserData.convert(user,new UserDO()));
    }
}
