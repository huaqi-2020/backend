package cn.edu.whu.huaqi_2020.web.facade;

import cn.edu.whu.huaqi_2020.entities.business.BusinessSpecial1;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/28 9:37
 **/
@FeignClient(
        value = "cloud-api-business",
        path = "/facade/businessSpecial1"
)
/**
 *@RestController 该注解作用：注册路径生成对应的HandlerMapping，但是facade接口端不需要进行映射，只需要通过feign发送正确的url即可，
 *而解析路径的任务应当交给服务被调用方；若加上@RestController注解反而会导致问题：例如：多个子路径相同时注册HandlerMapping冲突，
 *但其实这个HandlerMapping是没有实际意义的4
 */
public interface BusinessSpecial1Facade {

    //须保证mapping的唯一性
    @RequestMapping(
            value = "filter",
            method = RequestMethod.POST
    )
    //TODO 目前只支持date计算时间序列
    List<Map<String, Object>> getBusinessSpecial1FilterMap(@RequestBody BusinessSpecial1 businessSpecial1);

}
