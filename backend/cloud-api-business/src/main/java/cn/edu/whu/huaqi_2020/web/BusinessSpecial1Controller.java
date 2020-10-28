package cn.edu.whu.huaqi_2020.web;

import cc.eamon.open.auth.AuthGroup;
import cc.eamon.open.status.Status;
import cn.edu.whu.huaqi_2020.entities.business.BusinessSpecial1;
import cn.edu.whu.huaqi_2020.service.impl.BusinessSpecial1Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/26 16:15
 **/
@Api(
        value = "圈子分类1数据模块",
        tags = "圈子分类1数据模块"
)
@RestController
@RequestMapping("api/businessSpecial1")

public class BusinessSpecial1Controller {

    @Autowired
    private BusinessSpecial1Service businessSpecial1Service;

    @AuthGroup("admin")
    @ApiOperation(
            value = "查询圈子分类1信息",
            notes = "查询圈子分类1信息"
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @RequestMapping(
            value = "",
            method = RequestMethod.GET
    )
    public Map<String, Object> fetchB1(@RequestParam("id") String id){
        return Status.successBuilder()
                .addDataValue(businessSpecial1Service.selectByPrimaryKey(id))
                .map();
    }

    @AuthGroup("admin")
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
    public Map<String, Object> fetchBusinessSpecial1List(@RequestBody BusinessSpecial1 businessSpecial1){
        return Status.successBuilder()
                .addDataValue(businessSpecial1Service.selectByExample(businessSpecial1))
                .map();
    }

    @AuthGroup("admin")
    @ApiOperation(
            value = "发布实体",
            notes = "发布实体"
    )
    @RequestMapping(
            value = "",
            method = RequestMethod.POST
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @ResponseBody
    public Map<String, Object> post(@RequestBody BusinessSpecial1 postMapper) {
        return Status.successBuilder()
                .addDataValue(businessSpecial1Service.insert(postMapper))
                .map();
    }

    @AuthGroup("admin")
    @ApiOperation(
            value = "发布一组实体",
            notes = "发布一组实体"
    )
    @RequestMapping(
            value = "batch",
            method = RequestMethod.POST
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @ResponseBody
    public Map<String, Object> postBatch(@RequestBody ArrayList<BusinessSpecial1> postMappers) {
        List<Map<String, Object>> insertMapList = new LinkedList<>();
        for (BusinessSpecial1 postMapper : postMappers) {
            insertMapList.add(businessSpecial1Service.insert(postMapper));
        }
        return Status.successBuilder()
                .addDataValue(insertMapList)
                .map();
    }

    @AuthGroup("admin")
    @ApiOperation(
            value = "更新实体",
            notes = "更新实体"
    )
    @RequestMapping(
            value = "",
            method = RequestMethod.PATCH
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @ResponseBody
    public Map<String, Object> patch(@RequestBody BusinessSpecial1 updateMapper) {
        return Status.successBuilder()
                .addDataValue(businessSpecial1Service.updateByPrimaryKeySelective(updateMapper))
                .map();
    }

    @AuthGroup("admin")
    @ApiOperation(
            value = "删除实体",
            notes = "删除实体"
    )
    @RequestMapping(
            value = "",
            method = RequestMethod.DELETE
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @ResponseBody
    public Map<String, Object> delete(@RequestParam("entityKey") String entityKey) {
        return Status.successBuilder()
                .addDataValue(businessSpecial1Service.deleteByPrimaryKey(entityKey))
                .map();
    }

    @AuthGroup("admin")
    @ApiOperation(
            value = "删除一组实体",
            notes = "删除一组实体"
    )
    @RequestMapping(
            value = "batch",
            method = RequestMethod.DELETE
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @ResponseBody
    public Map<String, Object> deleteBatch(@RequestParam("entityKeys") ArrayList<String> entityKeys) {
        AtomicInteger count = new AtomicInteger();
        for (String entityKey : entityKeys) {
            count.addAndGet(businessSpecial1Service.deleteByPrimaryKey(entityKey));
        }
        return Status.successBuilder()
                .addDataValue(count.get())
                .map();
    }

}
