package cn.edu.whu.huaqi_2020.web.facade;

import cn.edu.whu.huaqi_2020.entities.business.BusinessSpecial1;
import cn.edu.whu.huaqi_2020.service.impl.BusinessSpecial1Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/11/4 11:04
 **/
@Api(
        value = "圈子分类1数据连接模块",
        tags = "圈子分类1数据连接模块"
)
@RestController
@RequestMapping("facade/businessSpecial1")
public class BusinessSpecial1FacadeImpl {

    @Autowired
    private BusinessSpecial1Service businessSpecial1Service;

    @ApiOperation(
            value = "查询圈子分类1数据筛选列表",
            notes = "查询圈子分类1数据筛选列表"
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @RequestMapping(
            value = "filter",
            method = RequestMethod.POST
    )
    public List<Map<String, Object>> getBusinessSpecial1List(@RequestBody BusinessSpecial1 businessSpecial1){
        return businessSpecial1Service.selectByExample(businessSpecial1);
    }
}
