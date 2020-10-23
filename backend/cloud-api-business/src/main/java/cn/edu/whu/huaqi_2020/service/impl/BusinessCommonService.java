package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.BusinessCommonDao;
import cn.edu.whu.huaqi_2020.entities.business.Business;
import cn.edu.whu.huaqi_2020.entities.business.BusinessCommon;
import cn.edu.whu.huaqi_2020.entities.business.BusinessCommonDefaultMapper;
import cn.edu.whu.huaqi_2020.entities.business.BusinessDefaultMapper;
import cn.edu.whu.huaqi_2020.service.IBusinessCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/23 21:13
 **/
@Service
public class BusinessCommonService implements IBusinessCommonService {

    @Autowired
    private BusinessCommonDao businessCommonDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return businessCommonDao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(BusinessCommon record) {
        businessCommonDao.insert(record);
        return BusinessCommonDefaultMapper.buildMap(record);
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(String id) {
        return BusinessCommonDefaultMapper.buildMap(businessCommonDao.selectByPrimaryKey(id));
    }

    @Override
    public List<Map<String, Object>> selectByExample(BusinessCommon record) {
        List<Map<String, Object>> businesses = new LinkedList<>();
        List<BusinessCommon> businessList = businessCommonDao.selectByExample(record);
        for (BusinessCommon business : businessList) {
            businesses.add(BusinessCommonDefaultMapper.buildMap(business));
        }
        return businesses;
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(BusinessCommon record) {
        businessCommonDao.updateByPrimaryKeySelective(record);
        return BusinessCommonDefaultMapper.buildMap(record);
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(BusinessCommon record) {
        businessCommonDao.updateByPrimaryKey(record);
        return BusinessCommonDefaultMapper.buildMap(record);
    }
}
