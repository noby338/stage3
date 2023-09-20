package priv.noby.lombok.example;

import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * 在 Java 中，使用 new 关键字创建对象时，需要指定对象的具体类型。
 * 但是在使用 Lombok 的 val 关键字时，可以省略类型的声明，由编译器根据右侧的赋值表达式推断出对象的类型。
 */
public class ValExample {

    public static void example() {
        //val代替ArrayList<String>和String类型
        val example = new ArrayList<String>();
        example.add("Hello World!");
        val foo= example.get(0);
        System.out.println(foo.toLowerCase());
    }

    public static void example2() {
        //val代替Map.Entry<Integer,String>类型
        val map = new HashMap<Integer, String>();
        map.put(0, "zero");
        map.put(5, "five");
        for (val entry : map.entrySet()) {
            System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        example();
        example2();
    }
}
