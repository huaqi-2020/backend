package cn.edu.whu.huaqi_2020.service.impl;

import cn.edu.whu.huaqi_2020.dao.VideoDao;
import cn.edu.whu.huaqi_2020.entities.business.Video;
import cn.edu.whu.huaqi_2020.entities.business.VideoDefaultMapper;
import cn.edu.whu.huaqi_2020.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/24 23:59
 **/
@Service
public class VideoService implements IVideoService {

    @Autowired
    private VideoDao videoDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return videoDao.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> insert(Video record) {
        videoDao.insert(record);
        return VideoDefaultMapper.buildMap(record);
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(String id) {
        return VideoDefaultMapper.buildMap(videoDao.selectByPrimaryKey(id));
    }

    @Override
    public List<Map<String, Object>> selectByExample(Video record) {
        List<Map<String, Object>> videoMapList = new LinkedList<>();
        videoDao.selectByExample(record).stream().forEach(v -> videoMapList.add(VideoDefaultMapper.buildMap(v)));
        return videoMapList;
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(Video record) {
        videoDao.updateByPrimaryKeySelective(record);
        return VideoDefaultMapper.buildMap(record);
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(Video record) {
        videoDao.updateByPrimaryKey(record);
        return VideoDefaultMapper.buildMap(record);
    }
}
