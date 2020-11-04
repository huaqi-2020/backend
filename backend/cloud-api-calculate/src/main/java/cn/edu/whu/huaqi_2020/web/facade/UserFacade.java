package cn.edu.whu.huaqi_2020.web.facade;

import cn.edu.whu.huaqi_2020.entities.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/28 9:37
 **/
@Component
@FeignClient(
        value = "cloud-api-user",
        path = "/api/user"
)
public interface UserFacade {

    @RequestMapping(
            value = "filter",
            method = RequestMethod.POST
    )
    Map<String, Object> getUserFilterMap(@RequestBody User user);
}
