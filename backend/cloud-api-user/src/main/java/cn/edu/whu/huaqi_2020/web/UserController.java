package cn.edu.whu.huaqi_2020.web;

import cc.eamon.open.auth.Auth;
import cc.eamon.open.auth.AuthExpression;
import cc.eamon.open.auth.AuthGroup;
import cc.eamon.open.auth.Logical;
import cc.eamon.open.status.Status;
import cn.edu.whu.huaqi_2020.dao.dataObject.UserDO;
import cn.edu.whu.huaqi_2020.entities.user.User;
import cn.edu.whu.huaqi_2020.entities.user.UserData;
import cn.edu.whu.huaqi_2020.service.impl.UserService;
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
 * Created by Zhu yuhan
 * Date:2020/9/28 11:14
 **/
@Api(
        value = "用户模块",
        tags = "用户模块"
)
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @AuthExpression("id==userId")
    @ApiOperation(
            value = "查询用户信息",
            notes = "查询用户信息"
    )
    @Transactional(
            rollbackFor = Exception.class
    )
    @RequestMapping(
            value = "info",
            method = RequestMethod.GET
    )
    public Map<String, Object> fetchUser(@RequestParam("id") String id){
        return userService.selectByPrimaryKey(id);
    }

    @AuthExpression("id==userId")
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
    public Map<String, Object> post(@RequestBody User postMapper) {
        return Status.successBuilder()
                .addDataValue(userService.insert(postMapper))
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
    public Map<String, Object> postBatch(@RequestBody ArrayList<User> postMappers) {
        List<Map<String, Object>> insertMapList = new LinkedList<>();
        for (User postMapper : postMappers) {
            insertMapList.add(userService.insert(postMapper));
        }
        return Status.successBuilder()
                .addDataValue(insertMapList)
                .map();
    }

    @AuthExpression("id==userId")
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
    public Map<String, Object> patch(@RequestBody User updateMapper) {
        return Status.successBuilder()
                .addDataValue(userService.updateByPrimaryKeySelective(UserData.convert(updateMapper,new UserDO())))
                .map();
    }

    @Auth(logical = Logical.OR)
    @AuthExpression("entityKey==userId")
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
                .addDataValue(userService.deleteByPrimaryKey(entityKey))
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
            count.addAndGet(userService.deleteByPrimaryKey(entityKey));
        }
        return Status.successBuilder()
                .addDataValue(count.get())
                .map();
    }

}