package cn.edu.whu.huaqi_2020.dao;

import cn.edu.whu.huaqi_2020.entities.business.Business;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Zhu yuhan
 * Date:2020/9/28 10:42
 **/
@Repository
@Mapper
public interface IBusinessDao extends BaseDao<Business, String> {
    @Override
    default int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    default int insert(Business record) {
        return 0;
    }

    @Override
    default int insertSelective(Business record) {
        return 0;
    }

    @Override
    default Business selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    default int updateByPrimaryKeySelective(Business record) {
        return 0;
    }

    @Override
    default int updateByPrimaryKey(Business record) {
        return 0;
    }
}
