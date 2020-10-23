package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.UserHobbyDao;
import cn.edu.whu.huaqi_2020.entities.user.UserHobby;
import cn.edu.whu.huaqi_2020.entities.user.UserHobbyDefaultMapper;
import cn.edu.whu.huaqi_2020.service.IUserHobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/23 20:30
 **/
@Service
public class UserHobbyService implements IUserHobbyService {

    @Autowired
    private UserHobbyDao userHobbyDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return userHobbyDao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(UserHobby record) {
        userHobbyDao.insert(record);
        return UserHobbyDefaultMapper.buildMap(record);
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(String id) {
        return UserHobbyDefaultMapper.buildMap(userHobbyDao.selectByPrimaryKey(id));
    }

    @Override
    public List<Map<String, Object>> selectByExample(UserHobby record) {
        List<Map<String,Object>> userHobbies = new LinkedList<>();
        List<UserHobby> userHobbyList = userHobbyDao.selectByExample(record);
        for (UserHobby userHobby : userHobbyList) {
            userHobbies.add(UserHobbyDefaultMapper.buildMap(userHobby));
        }
        return userHobbies;
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(UserHobby record) {
        userHobbyDao.updateByPrimaryKeySelective(record);
        return UserHobbyDefaultMapper.buildMap(record);
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(UserHobby record) {
        userHobbyDao.updateByPrimaryKey(record);
        return UserHobbyDefaultMapper.buildMap(record);
    }
}
