package cn.edu.whu.huaqi_2020.web.controller;

import cc.eamon.open.status.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/11/2 17:01
 **/
@RestController
@Api(
        value = "测试",
        tags = "测试"
)
public class TestController {

    @ApiOperation(
            value = "测试converter",
            notes = "测试converter"
    )
    @RequestMapping(
            value = "test/converter",
            method = RequestMethod.GET
    )
    public Map<String,Object> converterTest(@RequestParam("date") Date date){
        return Status.successBuilder()
                .addDataValue(date)
                .map();
    }

    //预处理方法
    @ModelAttribute("attr")
    public String addAttr(Model model){
        return "123456";
    }

    @ApiOperation(
            value = "测试attr",
            notes = "测试attr"
    )
    @RequestMapping(
            value = "test/attr",
            method = RequestMethod.GET
    )
    public Map<String, Object> getAttr(@ModelAttribute("attr")String attr, Model model){
        return Status.successBuilder()
                .addDataValue(attr)
                .map();
    }
}
