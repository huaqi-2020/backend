package cn.edu.whu.huaqi_2020.entities.user;

import cc.eamon.open.mapping.mapper.*;
import cn.edu.whu.huaqi_2020.dao.dataObject.UserDO;
import lombok.*;
/**
 * Created by Zhu yuhan
 * Date:2020/9/28 10:53
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Mapper(
        value = {"data"}, //MapperId
        name = {"UserData"} //类名
)
@MapperConvert(
        value = {"data"},
        type = {UserDO.class}
)
public class User {

    private String id;
    private String nickName;
//    private String phone;
//    private String email;

    @MapperModify(
            value = {"data",},
            modify = {"modifyPassword",},
            recover = {"modifyPassword",}
    )
    private String password;
    private Integer role;
    private String headUrl;
    private String profession;
    private String consume;

    public String modifyPassword(String password){
        byte[] bytes = password.getBytes();
        byte b = -1;
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] ^= b;
        }
        return new String(bytes);
    }
}
