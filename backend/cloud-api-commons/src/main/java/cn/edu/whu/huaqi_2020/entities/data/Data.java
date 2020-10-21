package cn.edu.whu.huaqi_2020.entities.data;

import cc.eamon.open.mapping.mapper.Mapper;
import cc.eamon.open.mapping.mapper.MapperExtra;
import cc.eamon.open.mapping.mapper.MapperRename;
import lombok.*;

import java.sql.Date;

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
        value = {"clazzData","goodData","storeData","ownerData",},
        name = {"ClazzData","GoodData","StoreData","OwnerData",}
)
public class Data {

    private String id;
    @MapperRename(
            value = {"clazzData","goodData","storeData","ownerData"},
            name = {"clazzId","goodId","storeId","ownerId"}
    )
    private String foreignId;
    private Date date;
    @MapperRename(
            value = {"clazzData","goodData","storeData","ownerData"},
            name = {"playMoney","saleMoney","saleMoney","playMoney"}
    )
    private Double money;
    @MapperRename(
            value = {"clazzData","goodData","storeData","ownerData"},
            name = {"playNum","saleNum","saleNum","playNum"}
    )
    private Long num;
}
