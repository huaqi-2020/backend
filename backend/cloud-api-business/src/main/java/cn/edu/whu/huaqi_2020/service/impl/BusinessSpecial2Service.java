package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.BusinessSpecial2Dao;
import cn.edu.whu.huaqi_2020.entities.business.BusinessSpecial2;
import cn.edu.whu.huaqi_2020.service.IBusinessSpecial2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/23 21:19
 **/
@Service
public class BusinessSpecial2Service implements IBusinessSpecial2Service {

    @Autowired
    private BusinessSpecial2Dao businessSpecial2Dao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return businessSpecial2Dao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(BusinessSpecial2 record) {
        businessSpecial2Dao.insert(record);
        return record.buildMap();
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(String id) {
        return businessSpecial2Dao.selectByPrimaryKey(id).buildMap();
    }

    @Override
    public List<Map<String, Object>> selectByExample(BusinessSpecial2 record) {
        List<Map<String, Object>> businessMapList = new LinkedList<>();
        businessSpecial2Dao.selectByExample(record).stream().forEach(b -> businessMapList.add(b.buildMap()));
        return businessMapList;
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(BusinessSpecial2 record) {
        businessSpecial2Dao.updateByPrimaryKeySelective(record);
        return record.buildMap();
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(BusinessSpecial2 record) {
        businessSpecial2Dao.updateByPrimaryKey(record);
        return record.buildMap();
    }
}
