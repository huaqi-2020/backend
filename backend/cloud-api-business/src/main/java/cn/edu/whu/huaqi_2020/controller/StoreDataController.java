package cn.edu.whu.huaqi_2020.controller;

import cc.eamon.open.auth.AuthGroup;
import cc.eamon.open.status.Status;
import cn.edu.whu.huaqi_2020.entities.data.StoreData;
import cn.edu.whu.huaqi_2020.service.impl.StoreDataService;
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
        value = "商店数据模块",
        tags = "商店数据模块"
)
@RestController
@RequestMapping("api/storeData")

public class StoreDataController {

    @Autowired
    private StoreDataService storeDataService;

    @AuthGroup("admin")
    @ApiOperation(
            value = "查询商品数据信息",
            notes = "查询商品数据信息"
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @RequestMapping(
            value = "",
            method = RequestMethod.GET
    )
    public Map<String, Object> fetchStoreData(@RequestParam("id") Integer id){
        return storeDataService.selectByPrimaryKey(id);
    }

    @AuthGroup("admin")
    @ApiOperation(
            value = "查询商店数据筛选列表",
            notes = "查询商店数据筛选列表"
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @RequestMapping(
            value = "filter",
            method = RequestMethod.POST
    )
    public Map<String, Object> fetchStoreDataList(@RequestBody StoreData storeData){
        return Status.successBuilder()
                .addDataValue(storeDataService.selectByExample(storeData))
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
    public Map<String, Object> post(@RequestBody StoreData postMapper) {
        return Status.successBuilder()
                .addDataValue(storeDataService.insert(postMapper))
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
    public Map<String, Object> postBatch(@RequestBody ArrayList<StoreData> postMappers) {
        List<Map<String, Object>> insertMapList = new LinkedList<>();
        for (StoreData postMapper : postMappers) {
            insertMapList.add(storeDataService.insert(postMapper));
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
    public Map<String, Object> patch(@RequestBody StoreData updateMapper) {
        return Status.successBuilder()
                .addDataValue(storeDataService.updateByPrimaryKey(updateMapper))
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
                .addDataValue(storeDataService.deleteByPrimaryKey(entityKey))
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
            count.addAndGet(storeDataService.deleteByPrimaryKey(entityKey));
        }
        return Status.successBuilder()
                .addDataValue(count.get())
                .map();
    }

}
