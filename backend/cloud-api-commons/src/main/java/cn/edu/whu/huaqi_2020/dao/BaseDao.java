package cn.edu.whu.huaqi_2020.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Zhu yuhan
 * Date:2020/9/28 10:56
 **/
public interface BaseDao<Model, PK extends Serializable> {

    int deleteByPrimaryKey(PK id);

    int insert(Model record);

    int insertSelective(Model record);

//    List<Model> selectByExample(E example);

    Model selectByPrimaryKey(PK id);

//    int updateByExampleSelective(@Param("record") Model record, @Param("example") E example);
//
//    int updateByExample(@Param("record") Model record, @Param("example") E example);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);
}
