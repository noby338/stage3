package priv.noby.spring.factory;

import priv.noby.spring.entity.School;

/**
 * 静态工厂(工厂静态方法实例化)(bean实例化的三种方式之一)
 *
 * @author Noby
 * @since 2022/10/8
 */
public class StaticFactory {
    public StaticFactory() {
        System.out.println("StaticFactory.StaticFactory 无参构造");
    }

    public static School getSchool(){
        System.out.println("StaticFactory.getSchool");
        return new School();
    }
}
