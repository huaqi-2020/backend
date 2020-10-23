package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.UserDao;
import cn.edu.whu.huaqi_2020.dao.dataObject.UserDO;
import cn.edu.whu.huaqi_2020.entities.user.User;
import cn.edu.whu.huaqi_2020.entities.user.UserData;
import cn.edu.whu.huaqi_2020.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhu yuhan
 * Date:2020/9/28 16:22
 **/
@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(User user) {
        userDao.insert(UserData.convert(user,new UserDO()));
        return UserData.buildMap(user);
    }

    @Override
    public Map<String,Object> selectByPrimaryKey(String id) {
        UserDO userDO = userDao.selectByPrimaryKey(id);
        //密码加密传回前端
        return UserData.buildMap(UserData.convert(userDO, new User()));
    }

    @Override
    public List<Map<String,Object>> selectByExample(String var) {
        List<Map<String,Object>> users = new LinkedList<>();
        List<UserDO> userDOS = userDao.selectByExample(var);
        for (UserDO userDO : userDOS) {
            users.add(UserData.buildMap(UserData.convert(userDO, new User())));
        }
        return users;
    }

    @Override
    public Map<String,Object> updateByPrimaryKeySelective(User user) {
        userDao.updateByPrimaryKeySelective(UserData.convert(user,new UserDO()));
        return UserData.buildMap(user);
    }

    @Override
    public Map<String,Object> updateByPrimaryKey(UserDO record) {
        userDao.updateByPrimaryKey(record);
        return UserData.buildMap(UserData.convert(record,new User()));
    }
}
