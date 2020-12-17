package cn.edu.whu.huaqi_2020.web.controller;

import cc.eamon.open.auth.AuthExpression;
import cc.eamon.open.auth.AuthGroup;
import cc.eamon.open.status.Status;
import cn.edu.whu.huaqi_2020.entities.business.BusinessSpecial1;
import cn.edu.whu.huaqi_2020.entities.user.User;
import cn.edu.whu.huaqi_2020.service.BusinessDataCalculateService;
import cn.edu.whu.huaqi_2020.web.facade.BusinessSpecial1Facade;
import cn.edu.whu.huaqi_2020.web.facade.UserFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    //已解决header传递性
//    @AuthExpression("id==bid")
    @AuthGroup("admin")
    @ApiOperation(
            value = "test",
            notes = "test"
    )
    @RequestMapping(
            value = "data",
            method = RequestMethod.GET
    )
    @Transactional
    public Map<String,Object> getBusinessSpecial1Data(@RequestParam("id") String id){
        return businessDataCalculateService.calculateBusinessSpecial1(new BusinessSpecial1(Integer.valueOf(id),null,null,null,null,null));
    }

}
