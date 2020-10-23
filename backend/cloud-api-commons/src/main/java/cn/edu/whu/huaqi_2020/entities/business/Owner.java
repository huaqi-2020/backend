package cn.edu.whu.huaqi_2020.entities.business;

import cc.eamon.open.mapping.mapper.Mapper;
import lombok.*;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/21 23:24
 **/
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Mapper
//Up，某部国漫等作品拥有者
public class Owner {

    private String id;
    private String businessId;
    private String name;
}
