package cn.edu.whu.huaqi_2020.web;

import cc.eamon.open.auth.AuthGroup;
import cc.eamon.open.status.Status;
import cn.edu.whu.huaqi_2020.entities.data.OwnerData;
import cn.edu.whu.huaqi_2020.service.impl.OwnerDataService;
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
        value = "UP主数据模块",
        tags = "UP主数据模块"
)
@RestController
@RequestMapping("api/ownerData")

public class OwnerDataController {

    @Autowired
    private OwnerDataService ownerDataService;

    @AuthGroup("admin")
    @ApiOperation(
            value = "查询UP主数据信息",
            notes = "查询UP主数据信息"
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @RequestMapping(
            value = "",
            method = RequestMethod.GET
    )
    public Map<String, Object> fetchOwnerData(@RequestParam("id") Integer id){
        return Status.successBuilder()
                .addDataValue(ownerDataService.selectByPrimaryKey(id))
                .map();
    }

    @AuthGroup("admin")
    @ApiOperation(
            value = "查询UP主数据筛选列表",
            notes = "查询UP主数据筛选列表"
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @RequestMapping(
            value = "filter",
            method = RequestMethod.POST
    )
    public Map<String, Object> fetchOwnerDataList(@RequestBody OwnerData ownerData){
        return Status.successBuilder()
                .addDataValue(ownerDataService.selectByExample(ownerData))
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
    public Map<String, Object> post(@RequestBody OwnerData postMapper) {
        return Status.successBuilder()
                .addDataValue(ownerDataService.insert(postMapper))
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
    public Map<String, Object> postBatch(@RequestBody ArrayList<OwnerData> postMappers) {
        List<Map<String, Object>> insertMapList = new LinkedList<>();
        for (OwnerData postMapper : postMappers) {
            insertMapList.add(ownerDataService.insert(postMapper));
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
    public Map<String, Object> patch(@RequestBody OwnerData updateMapper) {
        return Status.successBuilder()
                .addDataValue(ownerDataService.updateByPrimaryKeySelective(updateMapper))
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
    public Map<String, Object> delete(@RequestParam("entityKey") Integer entityKey) {
        return Status.successBuilder()
                .addDataValue(ownerDataService.deleteByPrimaryKey(entityKey))
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
    public Map<String, Object> deleteBatch(@RequestParam("entityKeys") ArrayList<Integer> entityKeys) {
        AtomicInteger count = new AtomicInteger();
        for (Integer entityKey : entityKeys) {
            count.addAndGet(ownerDataService.deleteByPrimaryKey(entityKey));
        }
        return Status.successBuilder()
                .addDataValue(count.get())
                .map();
    }

}
