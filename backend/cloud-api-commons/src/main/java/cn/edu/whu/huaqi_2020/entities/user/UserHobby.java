package cn.edu.whu.huaqi_2020.entities.user;

import cc.eamon.open.mapping.mapper.Mapper;
import lombok.*;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/21 23:27
 **/
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Mapper
public class UserHobby {

    private String id;
    private String userId;
    private String hobbyId;
}
