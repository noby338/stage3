package priv.noby.lombok.example;

import lombok.AllArgsConstructor;
import lombok.With;

/**
 * @With 是 Lombok 中的注解，用于为已有的不可变（immutable）类生成一个新的实例，该新实例与原实例相比只有某些字段的值不同。
 *
 * 使用 @With 注解时，Lombok 会为类中的每个字段生成一个对应的 withXxx 方法，用于创建一个新的实例，并将指定字段的值修改为新的值。
 * 返回的实例是原实例的副本，但指定字段的值已经被修改。
 */
@With
@AllArgsConstructor
public class WithExample {
    private Long id;
    private String name;
    private Integer age;

    public static void main(String[] args) {
        WithExample example1 = new WithExample(1L, "test", 20);
        WithExample example2 = example1.withAge(22);
        //将原对象进行clone并设置age，返回false
        System.out.println("example1 = " + example1);
        System.out.println("example2 = " + example2);
    }
}
