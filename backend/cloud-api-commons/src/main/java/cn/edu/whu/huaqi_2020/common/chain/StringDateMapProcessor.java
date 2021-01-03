package cn.edu.whu.huaqi_2020.common.chain;

import cc.eamon.open.chain.processor.UserBaseChainKeyProcessor;
import cc.eamon.open.chain.processor.metadata.ChainKeyProcessorMetadata;
import org.springframework.stereotype.Component;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2021/1/2 1:18
 **/
@Component
public class StringDateMapProcessor extends UserBaseChainKeyProcessor {

    static {
        registry(new ChainKeyProcessorMetadata(ChainConst.CHAIN_STRING_DATE_MAP, StringDateMapProcessor.class));
    }

    @Override
    public String getUserParserMapTag() {
        return ChainConst.CHAIN_STRING_DATE_MAP_PARSER_TAG;
    }

    @Override
    public void handle(String key, Object value) {
        System.out.println(value);
    }

    @Override
    public void init() {

    }
}
