package cn.edu.whu.huaqi_2020.web.controller;

import cc.eamon.open.auth.AuthGroup;
import cc.eamon.open.status.Status;
import cn.edu.whu.huaqi_2020.entities.data.VideoData;
import cn.edu.whu.huaqi_2020.service.impl.VideoDataService;
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
        value = "影视作品数据模块",
        tags = "影视作品数据模块"
)
@RestController
@RequestMapping("api/videoData")
public class VideoDataController {

    @Autowired
    private VideoDataService videoDataService;

    @AuthGroup("admin")
    @ApiOperation(
            value = "查询影视作品数据信息",
            notes = "查询影视作品数据信息"
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @RequestMapping(
            value = "",
            method = RequestMethod.GET
    )
    public Map<String, Object> fetchVideoData(@RequestParam("id") Integer id){
        return Status.successBuilder()
                .addDataValue(videoDataService.selectByPrimaryKey(id))
                .map();
    }

    @AuthGroup("admin")
    @ApiOperation(
            value = "查询影视作品数据筛选列表",
            notes = "查询影视作品数据筛选列表"
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @RequestMapping(
            value = "filter",
            method = RequestMethod.POST
    )
    public Map<String, Object> fetchVideoDataList(@RequestBody VideoData videoData){
        return Status.successBuilder()
                .addDataValue(videoDataService.selectByExample(videoData))
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
    public Map<String, Object> post(@RequestBody VideoData postMapper) {
        return Status.successBuilder()
                .addDataValue(videoDataService.insert(postMapper))
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
    public Map<String, Object> postBatch(@RequestBody ArrayList<VideoData> postMappers) {
        List<Map<String, Object>> insertMapList = new LinkedList<>();
        for (VideoData postMapper : postMappers) {
            insertMapList.add(videoDataService.insert(postMapper));
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
    public Map<String, Object> patch(@RequestBody VideoData updateMapper) {
        return Status.successBuilder()
                .addDataValue(videoDataService.updateByPrimaryKeySelective(updateMapper))
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
                .addDataValue(videoDataService.deleteByPrimaryKey(entityKey))
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
            count.addAndGet(videoDataService.deleteByPrimaryKey(entityKey));
        }
        return Status.successBuilder()
                .addDataValue(count.get())
                .map();
    }

}
