package cn.edu.whu.huaqi_2020.entities.data;

import cc.eamon.open.mapping.mapper.Mapper;
import cc.eamon.open.mapping.mapper.MapperExtra;
import cc.eamon.open.mapping.mapper.MapperRename;
import lombok.*;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/21 23:16
 **/
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Mapper(
        value = {"videoData","goodData","storeData","ownerData",},
        name = {"VideoData","GoodData","StoreData","OwnerData",}
)
@MapperExtra(
        value = {"goodData","storeData","videoData","videoData","videoData"},
        name = {"singleMoney","visit","collects","coins","thumbs"},
        type = {Double.class,Integer.class,Integer.class,Integer.class,Integer.class},
        typeArgs = {"null","null","null","null","null"},
        list = {false,false,false,false,false}
)
public class Data {

    private Integer id = null;
    @MapperRename(
            value = {"videoData","goodData","storeData","ownerData"},
            name = {"videoId","goodId","storeId","ownerId"}
    )
    private String foreignId;
    //数据有问题
    private String date;
    private Double money = null;
    @MapperRename(
            value = {"videoData"},
            name = {"playNum"}
    )
    private Long num = null;
}
