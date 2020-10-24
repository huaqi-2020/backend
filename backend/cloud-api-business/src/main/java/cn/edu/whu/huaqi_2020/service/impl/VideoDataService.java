package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.VideoDataDao;
import cn.edu.whu.huaqi_2020.entities.data.VideoData;
import cn.edu.whu.huaqi_2020.service.IVideoDataService;
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
public class VideoDataService implements IVideoDataService {

    @Autowired
    private VideoDataDao videoDataDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return videoDataDao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(VideoData record) {
        videoDataDao.insert(record);
        return record.buildMap();
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(Integer id) {
        return videoDataDao.selectByPrimaryKey(id).buildMap();
    }

    @Override
    public List<Map<String, Object>> selectByExample(VideoData record) {
        List<Map<String, Object>> videoDatas = new LinkedList<>();
        videoDataDao.selectByExample(record).stream().forEach(vd -> videoDatas.add(vd.buildMap()));
        return videoDatas;
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(VideoData record) {
        videoDataDao.updateByPrimaryKeySelective(record);
        return record.buildMap();
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(VideoData record) {
        videoDataDao.updateByPrimaryKey(record);
        return record.buildMap();
    }
}
