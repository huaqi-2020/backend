package cn.edu.whu.huaqi_2020.service.impl;


import cn.edu.whu.huaqi_2020.dao.dataObject.UserDO;
import cn.edu.whu.huaqi_2020.entities.user.User;
import cn.edu.whu.huaqi_2020.entities.user.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class UserCommonService {

    @Autowired
    private UserService userService;


    public Map<String, Object> post(User entity) {
        entity.setId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase().substring(0, 30));
        this.userService.insert(entity);
        return UserData.buildMapper(entity).buildMap();
    }

    public Map<String, Object> login(String account, String password) {
        User user = new User();
        user.setNickName(account);
        user.setPassword(password);
        UserDO filterMapper = UserData.convert(user,new UserDO());
        Map<String, Object> userMap = this.userService.selectByExample(filterMapper).stream().findFirst().get();
        userMap.put("token",Math.random());
        return userMap;

    }

    public Map<String, Object> logout(String account) {
        return null;
    }

    public Map<String, Object> register(User registerMapper) {
        return this.post(registerMapper);
    }

}
