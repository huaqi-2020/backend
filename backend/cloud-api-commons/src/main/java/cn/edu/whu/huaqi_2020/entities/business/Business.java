package cn.edu.whu.huaqi_2020.entities.business;

import cc.eamon.open.mapping.mapper.Mapper;
import lombok.*;
import org.checkerframework.common.reflection.qual.GetConstructor;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/18 17:46
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Mapper
public class Business {

    private String id;
    private String name;
    private Integer userNum;
    private Integer type;

}
