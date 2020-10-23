package cn.edu.whu.huaqi_2020.dao;

import cn.edu.whu.huaqi_2020.entities.business.Business;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Zhu yuhan
 * Date:2020/9/28 10:42
 **/
@Repository
public interface BusinessDao extends BaseDao<Business, String> {
}
