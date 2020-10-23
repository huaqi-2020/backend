package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.HobbyDao;
import cn.edu.whu.huaqi_2020.entities.user.Hobby;
import cn.edu.whu.huaqi_2020.service.IHobbyService;
import cn.edu.whu.huaqi_2020.service.IUserHobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/23 20:56
 **/
@Service
public class HobbyService implements IHobbyService {
    @Autowired
    private HobbyDao hobbyDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return hobbyDao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(Hobby record) {
        hobbyDao.insert(record);
        return this.buildMap(record);
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(String id) {
        return this.buildMap(hobbyDao.selectByPrimaryKey(id));
    }

    @Override
    public List<Map<String, Object>> selectByExample(Hobby record) {
        List<Map<String, Object>> hobbiesList = new LinkedList<>();
        List<Hobby> hobbies = hobbyDao.selectByExample(record);
        for (Hobby hobby : hobbies) {
            hobbiesList.add(this.buildMap(hobby));
        }
        return hobbiesList;
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(Hobby record) {
        hobbyDao.updateByPrimaryKeySelective(record);
        return this.buildMap(record);
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(Hobby record) {
        hobbyDao.updateByPrimaryKey(record);
        return this.buildMap(record);
    }

    private Map<String, Object> buildMap(Hobby hobby){
        Map<String,Object> hobbyMap = new HashMap<>();
        hobbyMap.put("name",hobby.getName());
        hobbyMap.put("id",hobby.getId());
        return hobbyMap;
    }
}
