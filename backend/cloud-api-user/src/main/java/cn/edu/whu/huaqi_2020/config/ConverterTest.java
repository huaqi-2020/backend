package cn.edu.whu.huaqi_2020.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2020/11/2 16:32
 **/
@Component
public class ConverterTest implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate;
//        //时区
//        ZoneId zoneId = ZoneId.systemDefault();
        java.util.Date parse;
        try {
            parse = simpleDateFormat.parse(s);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("parse String to Date error");
        }
        //通过Instant作为桥梁进行转化
        return new Date(parse.getTime());
    }
}
