package cn.edu.whu.huaqi_2020.entities.business;

import cc.eamon.open.mapping.mapper.Mapper;
import cc.eamon.open.mapping.mapper.MapperExtra;
import io.swagger.models.auth.In;
import lombok.*;
import org.mockito.internal.matchers.Null;

import java.sql.Date;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/21 22:53
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Mapper(
        value = {"special1","special2","data"},
        name = {"BusinessSpecial1","BusinessSpecial2","BusinessCommonData",}
)
@MapperExtra(
        value = {"special1","special1","special2","special2",},
        name = {"saleMoney","saleNum","money","playNum"},
        type = {Double.class,Long.class,Double.class,Long.class},
        typeArgs = {"null","null","null","null",},
        list = {false,false,false,false},
        defaultValues = {"0.0","0L","0.0","0L",}
)
public class BusinessCommon {

    private String id;
    private String businessId;
    private Date date;
    private Integer visit;
    private Integer search;
    private Double rate;

}
