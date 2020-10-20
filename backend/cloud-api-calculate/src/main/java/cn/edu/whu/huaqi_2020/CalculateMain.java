package cn.edu.whu.huaqi_2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Zhu yuhan
 * Date:2020/9/28 11:16
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class CalculateMain {

    public static void main(String[] args) {
        SpringApplication.run(CalculateMain.class,args);
    }
}
