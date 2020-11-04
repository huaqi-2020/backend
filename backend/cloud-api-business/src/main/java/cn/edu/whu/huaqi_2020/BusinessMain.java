package cn.edu.whu.huaqi_2020;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Zhu yuhan
 * Date:2020/9/28 11:18
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableKnife4j
@EnableFeignClients
@MapperScan(basePackages = "cn.edu.whu.huaqi_2020.dao")
public class BusinessMain {
    public static void main(String[] args) {
        SpringApplication.run(BusinessMain.class,args);
    }
}
