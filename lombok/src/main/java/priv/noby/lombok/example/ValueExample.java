package priv.noby.lombok.example;

import lombok.Value;

/**
 * @Value 是 Lombok 中的注解，用于自动生成不可变（immutable）的 Java Bean 类。
 * 它会自动为类的所有字段生成对应的私有 final 字段、构造函数、getter 方法，
 * 并且还会自动生成 equals()、hashCode() 和 toString() 方法。
 */
@Value
public class ValueExample {
    Long id;
    String name;
    Integer age;

    public static void main(String[] args) {
        //只能使用全参构造器
        ValueExample example = new ValueExample(1L,"test",20);
        // example.setName("andy") //没有生成setter方法，会报错
        // example.name="andy" //字段被设置为final类型，会报错
    }
}
