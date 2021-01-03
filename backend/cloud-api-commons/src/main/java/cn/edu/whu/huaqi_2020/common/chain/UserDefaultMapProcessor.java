package cn.edu.whu.huaqi_2020.common.chain;

import cc.eamon.open.chain.parser.ChainKeyParserEnum;
import cc.eamon.open.chain.processor.UserBaseChainKeyProcessor;
import cc.eamon.open.chain.processor.metadata.ChainKeyProcessorMetadata;
import org.springframework.stereotype.Component;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/12/30 21:23
 **/
//测试默认MapParser
@Component
public class UserDefaultMapProcessor extends UserBaseChainKeyProcessor {

    /**
     * 注册Processor
     */
    static {
        registry(new ChainKeyProcessorMetadata(ChainConst.CHAIN_DEFAULT_MAP, UserDefaultMapProcessor.class));
    }

    @Override
    public String getUserParserMapTag() {
        return ChainKeyParserEnum.DEFAULT_MAP_PARSER.getParserTag();
    }

    @Override
    public void handle(String key, Object value) {
        System.out.println(value);
    }

    @Override
    public void init() {

    }
}
