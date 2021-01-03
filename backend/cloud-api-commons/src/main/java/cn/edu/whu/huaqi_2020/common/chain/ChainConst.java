package cn.edu.whu.huaqi_2020.common.chain;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2021/1/2 16:17
 **/
//链路使用到的字符串常量，放在common层下

/**
 * 命名规则：尽量与类名保持一致
 * processor key: CHAIN_[chainKeyName]
 * parser tag: CHAIN_[chainKeyName]_PARSER_TAG
 */
public class ChainConst {

    public static final String CHAIN_KEY_PREFIX = "CHAIN-";

    public static final String CHAIN_DEFAULT_MAP = "DEFAULT_MAP";

    public static final String CHAIN_STRING_DATE_MAP_PARSER_TAG = "STRING_DATE_MAP";

    public static final String CHAIN_STRING_DATE_MAP = "STRING_DATE_MAP";

    public static final String CHAIN_USER = "USER";

    public static final String CHAIN_USER_PARSER_TAG = "USER";
}
