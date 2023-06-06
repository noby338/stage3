package priv.noby.spring.factory;


import lombok.Data;
import priv.noby.spring.entity.School;

/**
 * 动态工厂(工厂实例方法实例化)(bean实例化的三种方式之一)
 * <p>
 * 动态工厂可以更灵活地控制Bean的创建过程。
 * 例如，我们可以在动态工厂的实例方法中添加一些逻辑来控制Bean的创建过程，例如根据不同的条件创建不同的Bean实例。
 * 而静态工厂的创建逻辑是固定的，不太容易进行定制化。
 *
 * @author Noby
 * @since 2022/10/8
 */
@Data
public class DynamicFactory {
    private String name;
    private String type;
    public DynamicFactory() {
        System.out.println("DynamicFactory.DynamicFactory 无参构造");
    }
    public DynamicFactory(String type) {
        this.type = type;
        System.out.println("DynamicFactory.DynamicFactory 有参构造");
    }

    public School getSchool() {
        System.out.println("DynamicFactory.getSchool");
        //这里的逻辑可以返回不同的对象
        if ("admin".equals(type)) {
            return new School(1,"admin学校");
        }else if ("normal".equals(type)) {
            return new School(1,"normal学校");
        } else {
            throw new IllegalArgumentException("Invalid type: " + type);
        }
    }
}
