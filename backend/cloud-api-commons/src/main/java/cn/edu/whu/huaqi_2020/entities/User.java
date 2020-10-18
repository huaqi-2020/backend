package cn.edu.whu.huaqi_2020.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

/**
 * Created by Zhu yuhan
 * Date:2020/9/28 10:53
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private String id;
    private String nickName;
    private String phone;
    private String email;
    private String password;
    private int role;
    private String headUrl;
}
