package cn.edu.whu.huaqi_2020.dao;

import cn.edu.whu.huaqi_2020.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Zhu yuhan
 * Date:2020/9/28 10:42
 **/
@Repository
@Mapper
public interface IUserDao extends BaseDao<User,String> {
    @Override
    default int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    default int insert(User record) {
        return 0;
    }

    @Override
    default int insertSelective(User record) {
        return 0;
    }

    @Override
    default User selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    default int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    default int updateByPrimaryKey(User record) {
        return 0;
    }
}
