package cn.edu.whu.huaqi_2020.service;

import cn.edu.whu.huaqi_2020.dao.dataObject.UserDO;
import cn.edu.whu.huaqi_2020.entities.user.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhu yuhan
 * Date:2020/9/28 16:21
 **/
public interface IUserService extends BaseService<UserDO,String>{

    default int deleteByPrimaryKey(String id) {
        return 0;
    }

    default Map<String, Object> insert(User user) {
        return new HashMap<>();
    }

    default Map<String, Object> selectByPrimaryKey(String id) {
        return new HashMap<>();
    }

    default List<Map<String, Object>> selectByExample(UserDO record) {
        return new LinkedList<>();
    }

    default Map<String, Object> updateByPrimaryKeySelective(UserDO user) {
        return new HashMap<>();
    }

    default Map<String, Object> updateByPrimaryKey(UserDO user) {
        return new HashMap<>();
    }
}
