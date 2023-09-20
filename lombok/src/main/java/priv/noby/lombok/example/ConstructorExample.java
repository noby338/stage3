package priv.noby.lombok.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @RequiredArgsConstructor(staticName = "of") 是 Lombok 中的注解，用于生成一个包含所有必需参数的构造函数，并且提供一个静态工厂方法来创建对象。
 *
 * 使用 @RequiredArgsConstructor(staticName = "of") 注解时，需要注意以下几点：
 *
 * 只有被 @NonNull 注解修饰的字段才会被包含在生成的构造函数中。
 * 生成的构造函数会按照字段在类中的声明顺序进行参数的排列。
 * 静态工厂方法的名称为 "of"，可以根据需要自定义。
 *
 *
 * @NonNull 是 Lombok 中的注解，用于标记字段或参数为非空，即不能为空。当使用 @NonNull 注解修饰字段或参数后，
 * Lombok 会自动生成相应的空值检查代码，以确保在使用该字段或参数时不会出现空指针异常。
 */
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
public class ConstructorExample {
    @NonNull
    private Long id;
    private String name;
    private Integer age;

    public static void main(String[] args) {
        //无参构造器
        ConstructorExample example1 = new ConstructorExample();
        //全部参数构造器
        ConstructorExample example2 = new ConstructorExample(1L,"test",20);
        //@NonNull注解的必须参数构造器
        ConstructorExample example3 = ConstructorExample.of(1L);
    }
}
