package cn.edu.whu.huaqi_2020.controller;

import cn.edu.whu.huaqi_2020.service.IBusinessService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Zhu yuhan
 * Date:2020/9/28 16:15
 **/
@Api(
        value = "圈子模块",
        tags = "圈子模块"
)
@RestController
@RequestMapping("api/business")
public class BusinessController {

    @Autowired
    private IBusinessService newsService;

    @Autowired
    private RestTemplate restTemplate;
}
