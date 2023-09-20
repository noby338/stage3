package priv.noby.lombok.example;

import lombok.NonNull;

/**
 * @NonNull 是 Lombok 中的注解，用于标记字段或参数为非空，即不能为空。当使用 @NonNull 注解修饰字段或参数后，
 *  * Lombok 会自动生成相应的空值检查代码，以确保在使用该字段或参数时不会出现空指针异常。
 */
public class NonNullExample {
    private String name;
    public  NonNullExample(@NonNull String name){
        this.name = name;
    }

    public static void main(String[] args) {
        new NonNullExample("test");
        //会抛出NullPointerException
        new NonNullExample(null);
    }
}
