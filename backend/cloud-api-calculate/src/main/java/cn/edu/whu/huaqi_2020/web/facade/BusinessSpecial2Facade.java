package cn.edu.whu.huaqi_2020.web.facade;

import cn.edu.whu.huaqi_2020.entities.business.BusinessSpecial2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/28 9:37
 **/
@FeignClient(
        value = "cloud-api-business",
        path = "/facade/businessSpecial2"
)
public interface BusinessSpecial2Facade {

    @RequestMapping(
            value = "filter",
            method = RequestMethod.POST
    )
    Map<String, Object> getBusinessSpecial2FilterMap(@RequestBody BusinessSpecial2 businessSpecial2);

}
