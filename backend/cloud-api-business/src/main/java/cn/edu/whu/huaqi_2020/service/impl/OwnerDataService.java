package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.OwnerDataDao;
import cn.edu.whu.huaqi_2020.entities.data.OwnerData;
import cn.edu.whu.huaqi_2020.service.IOwnerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/23 22:09
 **/
@Service
public class OwnerDataService implements IOwnerDataService {

    @Autowired
    private OwnerDataDao ownerDataDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return ownerDataDao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(OwnerData record) {
        ownerDataDao.insert(record);
        return record.buildMap();
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(Integer id) {
        return ownerDataDao.selectByPrimaryKey(id).buildMap();
    }

    @Override
    public List<Map<String, Object>> selectByExample(OwnerData record) {
        List<Map<String, Object>> ownerDatas = new LinkedList<>();
        ownerDataDao.selectByExample(record).stream().forEach(od -> ownerDatas.add(od.buildMap()));
        return ownerDatas;
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(OwnerData record) {
        ownerDataDao.updateByPrimaryKeySelective(record);
        return record.buildMap();
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(OwnerData record) {
        ownerDataDao.updateByPrimaryKey(record);
        return record.buildMap();
    }
}
