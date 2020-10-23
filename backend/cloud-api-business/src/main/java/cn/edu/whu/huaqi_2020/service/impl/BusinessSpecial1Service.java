package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.BusinessSpecial1Dao;
import cn.edu.whu.huaqi_2020.dao.BusinessSpecial2Dao;
import cn.edu.whu.huaqi_2020.entities.business.BusinessSpecial1;
import cn.edu.whu.huaqi_2020.service.IBusinessSpecial1Service;
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
public class BusinessSpecial1Service implements IBusinessSpecial1Service {

    @Autowired
    private BusinessSpecial1Dao businessSpecial1Dao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return businessSpecial1Dao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(BusinessSpecial1 record) {
        businessSpecial1Dao.insert(record);
        return record.buildMap();
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(String id) {
        return businessSpecial1Dao.selectByPrimaryKey(id).buildMap();
    }

    @Override
    public List<Map<String, Object>> selectByExample(BusinessSpecial1 record) {
        List<Map<String, Object>> businessMapList = new LinkedList<>();
        businessSpecial1Dao.selectByExample(record).stream().forEach(b -> businessMapList.add(b.buildMap()));
        return businessMapList;
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(BusinessSpecial1 record) {
        businessSpecial1Dao.updateByPrimaryKeySelective(record);
        return record.buildMap();
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(BusinessSpecial1 record) {
        businessSpecial1Dao.updateByPrimaryKey(record);
        return record.buildMap();
    }
}
