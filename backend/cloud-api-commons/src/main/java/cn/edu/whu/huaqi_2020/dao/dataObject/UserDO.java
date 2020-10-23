package cn.edu.whu.huaqi_2020.dao.dataObject;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {
  public String id;

  public String nickName;

  public String password;

  public Integer role;

  public String headUrl;

  public String profession;

  public String consume;
}
