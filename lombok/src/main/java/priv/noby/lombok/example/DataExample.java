package priv.noby.lombok.example;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * @Data 是 Lombok 中的注解，它是一个组合注解，包含了以下几个注解：
 *
 * @Getter: 自动生成字段的 getter 方法。
 * @Setter: 自动生成字段的 setter 方法。
 * @ToString: 自动生成 toString() 方法。
 * @EqualsAndHashCode: 自动生成 equals() 和 hashCode() 方法。
 *
 *
 * @EqualsAndHashCode.Exclude 是 Lombok 中的注解，用于在生成 equals() 和 hashCode() 方法时排除指定字段。通过使用 @EqualsAndHashCode.Exclude 注解，可以选择性地排除某些字段，使其不参与 equals() 和 hashCode() 方法的比较和计算。
 *
 * 使用 @EqualsAndHashCode.Exclude 注解时，需要注意以下几点：
 *
 * @EqualsAndHashCode.Exclude 注解可以用于字段上。
 * 被 @EqualsAndHashCode.Exclude 注解修饰的字段不会参与 equals() 和 hashCode() 方法的比较和计算。
 * 可以在注解中指定一个或多个字段进行排除，多个字段之间使用逗号分隔。
 */
@Data
public class DataExample {
    @NonNull
    private Long id;
    @EqualsAndHashCode.Exclude
    private String name;
    @EqualsAndHashCode.Exclude
    private Integer age;

    public static void main(String[] args) {
        //@RequiredArgsConstructor已生效
        /*
        Java类如果没有定义任何构造函数,编译器会添加一个默认无参构造函数。
        @NonNull注解表明id属性是必须非空的。
        所以编译器会默认添加一个只有id参数的构造函数,确保id不为空。
         */
        DataExample example1 = new DataExample(1L);
        //@Getter @Setter已生效
        example1.setName("test");
        example1.setAge(20);
        //@ToString已生效
        System.out.println(example1);
        DataExample example2 = new DataExample(1L);
        //@EqualsAndHashCode已生效
        System.out.println(example1.equals(example2));
    }
}
