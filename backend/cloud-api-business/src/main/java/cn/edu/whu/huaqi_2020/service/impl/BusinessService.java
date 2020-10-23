package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.BusinessDao;
import cn.edu.whu.huaqi_2020.entities.business.Business;
import cn.edu.whu.huaqi_2020.entities.business.BusinessDefaultMapper;
import cn.edu.whu.huaqi_2020.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhu yuhan
 * Date:2020/9/28 16:17
 **/
@Service
public class BusinessService implements IBusinessService {

    @Autowired
    private BusinessDao businessDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return businessDao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(Business record) {
        businessDao.insert(record);
        return BusinessDefaultMapper.buildMap(record);
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(String id) {
        return BusinessDefaultMapper.buildMap(businessDao.selectByPrimaryKey(id));
    }

    @Override
    public List<Map<String, Object>> selectByExample(Business record) {
        List<Map<String, Object>> businesses = new LinkedList<>();
        List<Business> businessList = businessDao.selectByExample(record);
        for (Business business : businessList) {
            businesses.add(BusinessDefaultMapper.buildMap(business));
        }
        return businesses;
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(Business record) {
        businessDao.updateByPrimaryKeySelective(record);
        return BusinessDefaultMapper.buildMap(record);
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(Business record) {
        businessDao.updateByPrimaryKey(record);
        return BusinessDefaultMapper.buildMap(record);
    }
}
