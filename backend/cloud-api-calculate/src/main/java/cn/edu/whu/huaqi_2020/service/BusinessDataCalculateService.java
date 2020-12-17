package cn.edu.whu.huaqi_2020.service;

import cc.eamon.open.status.Status;
import cn.edu.whu.huaqi_2020.entities.business.BusinessSpecial1;
import cn.edu.whu.huaqi_2020.entities.user.User;
import cn.edu.whu.huaqi_2020.web.facade.BusinessSpecial1Facade;
import cn.edu.whu.huaqi_2020.web.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/28 9:20
 **/
@Service
public class BusinessDataCalculateService {

    //不能根据名字识别，只能通过编译后的字节码检查类型注入
    @Resource
    private BusinessSpecial1Facade businessSpecial1Facade;

    @Resource
    private UserFacade userFacade;

    /**
     * 计算圈子1时间序列值
     * @param businessSpecial1
     * @return
     */
    public Map<String, Object> calculateBusinessSpecial1(BusinessSpecial1 businessSpecial1){
        return Status.successBuilder()
                .addDataValue(businessSpecial1Facade.getBusinessSpecial1FilterMap(businessSpecial1))
                .map();
    }
}
