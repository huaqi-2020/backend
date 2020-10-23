package cn.edu.whu.huaqi_2020.entities.user;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/10/21 23:21
 **/
public enum Hobby {
    HOBBY1("1","hobby1"),
    HOBBY2("2","hobby2"),
    HOBBY3("3","hobby3");

    private String id;
    private String name;

    Hobby(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
