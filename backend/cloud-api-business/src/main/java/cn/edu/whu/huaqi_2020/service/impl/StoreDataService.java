package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.StoreDataDao;
import cn.edu.whu.huaqi_2020.entities.data.StoreData;
import cn.edu.whu.huaqi_2020.service.IStoreDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/23 22:10
 **/
@Service
public class StoreDataService implements IStoreDataService {

    @Autowired
    private StoreDataDao storeDataDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return storeDataDao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(StoreData record) {
        storeDataDao.insert(record);
        return record.buildMap();
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(String id) {
        return storeDataDao.selectByPrimaryKey(id).buildMap();
    }

    @Override
    public List<Map<String, Object>> selectByExample(StoreData record) {
        List<Map<String, Object>> storeDatas = new LinkedList<>();
        storeDataDao.selectByExample(record).stream().forEach(sd -> storeDatas.add(sd.buildMap()));
        return storeDatas;
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(StoreData record) {
        storeDataDao.updateByPrimaryKeySelective(record);
        return record.buildMap();
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(StoreData record) {
        storeDataDao.updateByPrimaryKey(record);
        return record.buildMap();
    }
}
