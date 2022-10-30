package priv.noby.springmvc5.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该类用于自定义类型转换
 *
 * controller中的方法参数对于请求参数的封装，String=>int等可以自动完成，
 * 但部分数据类型不可自动完成或达不到自定义预期，可使用自定义数据类型的转换
 * 该类的作用使用将Date数据类型由默认的"yyyy/MM/dd"=>Date自定义为"yyyy-MM-dd"=>Date
 * @author Noby
 * @since 2022/10/13
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
