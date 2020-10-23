package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.GoodDao;
import cn.edu.whu.huaqi_2020.entities.business.Good;
import cn.edu.whu.huaqi_2020.entities.business.GoodDefaultMapper;
import cn.edu.whu.huaqi_2020.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/23 21:50
 **/
@Service
public class GoodService implements IGoodService {
    @Autowired
    private GoodDao goodDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return goodDao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(Good record) {
        goodDao.insert(record);
        return GoodDefaultMapper.buildMap(record);
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(String id) {
        return GoodDefaultMapper.buildMap(goodDao.selectByPrimaryKey(id));
    }

    @Override
    public List<Map<String, Object>> selectByExample(Good record) {
        List<Map<String, Object>> goods = new LinkedList<>();
        goodDao.selectByExample(record).stream().forEach(g -> goods.add(GoodDefaultMapper.buildMap(g)));
        return goods;
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(Good record) {
        goodDao.updateByPrimaryKeySelective(record);
        return GoodDefaultMapper.buildMap(record);
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(Good record) {
        goodDao.updateByPrimaryKey(record);
        return GoodDefaultMapper.buildMap(record);
    }
}
