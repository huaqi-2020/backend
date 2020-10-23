package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.StoreDao;
import cn.edu.whu.huaqi_2020.entities.business.Store;
import cn.edu.whu.huaqi_2020.entities.business.StoreDefaultMapper;
import cn.edu.whu.huaqi_2020.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/23 21:53
 **/
@Service
public class StoreService implements IStoreService {

    @Autowired
    private StoreDao storeDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return storeDao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(Store record) {
        storeDao.insert(record);
        return StoreDefaultMapper.buildMap(record);
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(String id) {
        return StoreDefaultMapper.buildMap(storeDao.selectByPrimaryKey(id));
    }

    @Override
    public List<Map<String, Object>> selectByExample(Store record) {
        List<Map<String, Object>> storeMapList = new LinkedList<>();
        storeDao.selectByExample(record).stream().forEach(s -> storeMapList.add(StoreDefaultMapper.buildMap(s)));
        return storeMapList;
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(Store record) {
        storeDao.updateByPrimaryKeySelective(record);
        return StoreDefaultMapper.buildMap(record);
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(Store record) {
        storeDao.updateByPrimaryKey(record);
        return StoreDefaultMapper.buildMap(record);
    }
}
