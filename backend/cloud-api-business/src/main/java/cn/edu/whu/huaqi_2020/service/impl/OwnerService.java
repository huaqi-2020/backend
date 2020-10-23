package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.OwnerDao;
import cn.edu.whu.huaqi_2020.entities.business.Owner;
import cn.edu.whu.huaqi_2020.entities.business.OwnerDefaultMapper;
import cn.edu.whu.huaqi_2020.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/23 21:57
 **/
@Service
public class OwnerService implements IOwnerService {

    @Autowired
    private OwnerDao ownerDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ownerDao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(Owner record) {
        ownerDao.insert(record);
        return OwnerDefaultMapper.buildMap(record);
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(String id) {
        return OwnerDefaultMapper.buildMap(ownerDao.selectByPrimaryKey(id));
    }

    @Override
    public List<Map<String, Object>> selectByExample(Owner record) {
        List<Map<String, Object>> ownerMapList = new LinkedList<>();
        ownerDao.selectByExample(record).stream().forEach(o -> ownerMapList.add(OwnerDefaultMapper.buildMap(o)));
        return ownerMapList;
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(Owner record) {
        ownerDao.updateByPrimaryKeySelective(record);
        return OwnerDefaultMapper.buildMap(record);
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(Owner record) {
        ownerDao.updateByPrimaryKey(record);
        return OwnerDefaultMapper.buildMap(record);
    }
}
