package priv.noby.note.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 配置日期转换器，用于统一处理字符串和日期的转换
 * 该类的使用需要在SpringMVC中配置
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(s);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
