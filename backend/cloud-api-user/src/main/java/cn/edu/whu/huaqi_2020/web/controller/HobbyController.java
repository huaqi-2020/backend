package cn.edu.whu.huaqi_2020.web.controller;

import cc.eamon.open.auth.AuthGroup;
import cc.eamon.open.auth.Logical;
import cc.eamon.open.status.Status;
import cn.edu.whu.huaqi_2020.entities.user.Hobby;
import cn.edu.whu.huaqi_2020.service.impl.HobbyService;
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
 * Date: 2020/10/26 15:47
 **/
@Api(
        value = "爱好模块",
        tags = "爱好模块"
)
@RestController
@RequestMapping("api/hobby")
public class HobbyController {

    @Autowired
    private HobbyService hobbyService;

    @ApiOperation(
            value = "查询爱好",
            notes = "查询爱好"
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @RequestMapping(
            value = "",
            method = RequestMethod.GET
    )
    public Map<String, Object> fetchHobby(@RequestParam("id") String id){
        return hobbyService.selectByPrimaryKey(id);
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
    public Map<String, Object> post(@RequestBody Hobby postMapper) {
        return Status.successBuilder()
                .addDataValue(hobbyService.insert(postMapper))
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
    public Map<String, Object> postBatch(@RequestBody ArrayList<Hobby> postMappers) {
        List<Map<String, Object>> insertMapList = new LinkedList<>();
        for (Hobby postMapper : postMappers) {
            insertMapList.add(hobbyService.insert(postMapper));
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
    public Map<String, Object> patch(@RequestBody Hobby updateMapper) {
        return Status.successBuilder()
                .addDataValue(hobbyService.updateByPrimaryKeySelective(updateMapper))
                .map();
    }

    @AuthGroup(value = {"super","admin"},logical = Logical.OR)
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
                .addDataValue(hobbyService.deleteByPrimaryKey(entityKey))
                .map();
    }

    @AuthGroup(value = {"super","admin"},logical = Logical.AND)
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
            count.addAndGet(hobbyService.deleteByPrimaryKey(entityKey));
        }
        return Status.successBuilder()
                .addDataValue(count.get())
                .map();
    }
}
