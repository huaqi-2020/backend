package cn.edu.whu.huaqi_2020.config;

import cc.eamon.open.chain.ChainContextHolder;
import cc.eamon.open.chain.interceptor.support.FeignChainContextRequestInterceptor;
import cc.eamon.open.chain.parser.map.UserGenericMap;
import cc.eamon.open.chain.parser.metadata.GenericChainKeyParserMetadata;
import cc.eamon.open.chain.temp.ChainContextHandlerInterceptor;
import cn.edu.whu.huaqi_2020.common.chain.ChainConst;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/12/4 22:03
 **/
@Configuration
public class ChainContextAdvice extends FeignChainContextRequestInterceptor implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ChainContextHandlerInterceptor());
    }

    @Override
    public void parseChainContext() {
//        ChainKeyParserInstance.addChainKeyParser(new ChainKeyParserInstance("USER", User.class, new ParserProcessor()));
    }

    @Override
    public void addChainContext(HttpServletRequest httpServletRequest) {
        //add into chainContext or requestAttr
//        httpServletRequest.setAttribute(xxx,xxx);
        ChainContextHolder.put("CHAIN-STRING", "123456");
        Map<String, String> defaultMap = new HashMap<>();
        defaultMap.put("a", "123");
        defaultMap.put("b", "456");
        ChainContextHolder.put(ChainConst.CHAIN_KEY_PREFIX + ChainConst.CHAIN_DEFAULT_MAP, defaultMap);
        UserGenericMap<String, Date> userGenericMap = new UserGenericMap<String, Date>() {
            @Override
            protected GenericChainKeyParserMetadata.GenericMetadata genericMetadata() {
                return new GenericChainKeyParserMetadata.GenericMetadata(String.class, Date.class);
            }
        };
        userGenericMap.put("a", new Date(123L));
        ChainContextHolder.put(ChainConst.CHAIN_KEY_PREFIX + ChainConst.CHAIN_STRING_DATE_MAP, userGenericMap);
    }

    @Override
    public boolean checkChainContext() {
        return super.checkChainContext();
        //check else
    }

    //保留操作
    @Override
    public void applyChainContext() {
        super.applyChainContext();
    }
}
