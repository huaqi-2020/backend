package cn.edu.whu.huaqi_2020.service;

import cn.edu.whu.huaqi_2020.dao.dataObject.UserDO;
import cn.edu.whu.huaqi_2020.entities.user.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/23 20:46
 **/
public interface BaseService<Model, PK extends Serializable> {

    default int deleteByPrimaryKey(PK id) {
        return 0;
    }

    default Map<String, Object> insert(Model record) {
        return new HashMap<>();
    }

    default Map<String, Object> selectByPrimaryKey(PK id) {
        return new HashMap<>();
    }

    default List<Map<String, Object>> selectByExample(Model record) {
        return new LinkedList<>();
    }

    default Map<String, Object> updateByPrimaryKeySelective(Model record) {
        return new HashMap<>();
    }

    default Map<String, Object> updateByPrimaryKey(Model record) {
        return new HashMap<>();
    }
}
