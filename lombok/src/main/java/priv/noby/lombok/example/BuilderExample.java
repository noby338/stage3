package priv.noby.lombok.example;

import lombok.Builder;

/**
 * @Builder 注解是用于生成构建器模式的代码。通过使用 @Builder 注解，我们可以简化创建复杂对象的过程
 */
@Builder
public class BuilderExample {
    private Long id;
    private String name;
    private Integer age;

    public static void main(String[] args) {
        BuilderExample example = BuilderExample.builder()
                .id(1L)
                .name("test")
                .age(20)
                .build();
        System.out.println(example);
    }
}
