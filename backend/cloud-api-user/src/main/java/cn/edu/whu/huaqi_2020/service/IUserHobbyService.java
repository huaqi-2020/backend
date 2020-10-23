package cn.edu.whu.huaqi_2020.service;

import cn.edu.whu.huaqi_2020.entities.user.UserHobby;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhu yuhan
 * Date:2020/9/28 16:21
 **/
public interface IUserHobbyService extends BaseService<UserHobby,String> {

    default int deleteByPrimaryKey(String id) {
        return 0;
    }

    default Map<String, Object> insert(UserHobby record) {
        return new HashMap<>();
    }

    default Map<String, Object> selectByPrimaryKey(String id) {
        return new HashMap<>();
    }

    default List<Map<String, Object>> selectByExample(UserHobby record) {
        return new LinkedList<>();
    }

    default Map<String, Object> updateByPrimaryKeySelective(UserHobby record) {
        return new HashMap<>();
    }

    default Map<String, Object> updateByPrimaryKey(UserHobby record) {
        return new HashMap<>();
    }
}
