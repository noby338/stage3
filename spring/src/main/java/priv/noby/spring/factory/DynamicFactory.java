package priv.noby.spring.factory;


import priv.noby.spring.entity.School;

/**
 * 动态工厂(工厂实例方法实例化)(bean实例化的三种方式之一)
 *
 * @author Noby
 * @since 2022/10/8
 */
public class DynamicFactory {
    public DynamicFactory() {
        System.out.println("DynamicFactory.DynamicFactory 无参构造");
    }
    public School getSchool(){
        System.out.println("DynamicFactory.getSchool");
        return new School();
    }
}
