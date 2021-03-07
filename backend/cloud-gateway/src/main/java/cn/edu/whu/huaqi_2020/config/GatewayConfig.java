package cn.edu.whu.huaqi_2020.config;

import cn.edu.whu.huaqi_2020.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: eamon
 * Email: eamon@eamon.cc
 * Time: 2020-03-17 18:18:39
 */

@Configuration
public class GatewayConfig {

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }
}
