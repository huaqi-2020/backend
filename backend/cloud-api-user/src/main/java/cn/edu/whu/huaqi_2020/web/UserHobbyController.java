package cn.edu.whu.huaqi_2020.web;

import cc.eamon.open.auth.AuthExpression;
import cc.eamon.open.auth.AuthGroup;
import cc.eamon.open.auth.Logical;
import cc.eamon.open.status.Status;
import cn.edu.whu.huaqi_2020.entities.user.UserHobby;
import cn.edu.whu.huaqi_2020.service.impl.UserHobbyService;
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
 * Date: 2020/10/26 15:36
 **/
@Api(
        value = "用户爱好模块",
        tags = "用户爱好模块"
)
@RestController
@RequestMapping("api/userHobby")
public class UserHobbyController {

    @Autowired
    private UserHobbyService userHobbyService;

    @AuthGroup("admin")
    @ApiOperation(
            value = "查询用户爱好",
            notes = "查询用户爱好"
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @RequestMapping(
            value = "",
            method = RequestMethod.GET
    )
    public Map<String, Object> fetchUserHobby(@RequestParam("id") String id){
        return userHobbyService.selectByPrimaryKey(id);
    }

    @AuthExpression("userId==#userId")
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
    public Map<String, Object> post(@RequestBody UserHobby postMapper) {
        return Status.successBuilder()
                .addDataValue(userHobbyService.insert(postMapper))
                .map();
    }

    @AuthExpression("userId==#userId")
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
    public Map<String, Object> postBatch(@RequestBody ArrayList<UserHobby> postMappers) {
        List<Map<String, Object>> insertMapList = new LinkedList<>();
        for (UserHobby postMapper : postMappers) {
            insertMapList.add(userHobbyService.insert(postMapper));
        }
        return Status.successBuilder()
                .addDataValue(insertMapList)
                .map();
    }

    @AuthExpression("userId==#userId")
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
    public Map<String, Object> patch(@RequestBody UserHobby updateMapper) {
        return Status.successBuilder()
                .addDataValue(userHobbyService.updateByPrimaryKeySelective(updateMapper))
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
                .addDataValue(userHobbyService.deleteByPrimaryKey(entityKey))
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
            count.addAndGet(userHobbyService.deleteByPrimaryKey(entityKey));
        }
        return Status.successBuilder()
                .addDataValue(count.get())
                .map();
    }
}
