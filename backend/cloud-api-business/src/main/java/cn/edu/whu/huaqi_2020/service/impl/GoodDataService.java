package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.GoodDataDao;
import cn.edu.whu.huaqi_2020.entities.data.GoodData;
import cn.edu.whu.huaqi_2020.service.IGoodDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/23 22:04
 **/
@Service
public class GoodDataService implements IGoodDataService {

    @Autowired
    private GoodDataDao goodDataDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodDataDao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(GoodData record) {
        goodDataDao.insert(record);
        return record.buildMap();
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(Integer id) {
        return goodDataDao.selectByPrimaryKey(id).buildMap();
    }

    @Override
    public List<Map<String, Object>> selectByExample(GoodData record) {
        List<Map<String,Object>> goodDatas = new LinkedList<>();
        goodDataDao.selectByExample(record).stream().forEach(gd -> goodDatas.add(gd.buildMap()));
        return goodDatas;
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(GoodData record) {
        goodDataDao.updateByPrimaryKeySelective(record);
        return record.buildMap();
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(GoodData record) {
        goodDataDao.updateByPrimaryKey(record);
        return record.buildMap();
    }
}
