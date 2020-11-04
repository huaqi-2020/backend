package cn.edu.whu.huaqi_2020.web.controller;

import cn.edu.whu.huaqi_2020.entities.business.BusinessSpecial1;
import cn.edu.whu.huaqi_2020.service.BusinessDataCalculateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Zhu yuhan
 * Date:2020/9/28 11:14
 **/
@Api(
        value = "计算模块",
        tags = "计算模块"
)
@RestController
@RequestMapping("api/calculate")
public class CalculateController {

    @Autowired
    private BusinessDataCalculateService businessDataCalculateService;

//    @AuthExpression("userId==id")
    //不具有传递性
    @ApiOperation(
            value = "计算圈子1数据",
            notes = "计算圈子1数据"
    )
    @RequestMapping(
            value = "businessSpecial1Data",
            method = RequestMethod.POST
    )
    @Transactional
    @ResponseBody
    public Map<String,Object> calculateBusinessSpecial1Data(@RequestBody BusinessSpecial1 businessSpecial1){
        return businessDataCalculateService.calculateBusinessSpecial1(businessSpecial1);
    }

}
