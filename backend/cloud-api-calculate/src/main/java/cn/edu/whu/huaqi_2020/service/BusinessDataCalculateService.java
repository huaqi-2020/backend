package cn.edu.whu.huaqi_2020.service;

import cc.eamon.open.status.Status;
import cn.edu.whu.huaqi_2020.entities.business.BusinessSpecial1;
import cn.edu.whu.huaqi_2020.web.facade.BusinessSpecial1Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/28 9:20
 **/
@Service
public class BusinessDataCalculateService {

    @Autowired
    private BusinessSpecial1Facade businessSpecial1Facade;

    /**
     * 计算圈子1时间序列值
     * @param businessSpecial1
     * @return
     */
    public Map<String, Object> calculateBusinessSpecial1(BusinessSpecial1 businessSpecial1){
        List<Map<String, Object>> businessSpecial1FilterMap = businessSpecial1Facade.getBusinessSpecial1FilterMap(businessSpecial1);
        //test
        return Status.successBuilder()
                .addDataValue(businessSpecial1FilterMap)
                .map();
    }
}
