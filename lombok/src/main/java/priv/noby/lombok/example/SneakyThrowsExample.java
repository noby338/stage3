package priv.noby.lombok.example;

import lombok.SneakyThrows;

import java.io.UnsupportedEncodingException;

/**
 * @SneakyThrows() 是 Lombok 中的注解，用于在方法中自动处理受检异常（checked exception）。
 * 它可以减少编写 try-catch 块的代码量，使代码更加简洁。
 */
public class SneakyThrowsExample {

    //自动抛出异常，无需处理
//    @SneakyThrows
    @SneakyThrows(UnsupportedEncodingException.class)
    public static byte[] str2byte(String str){
        return str.getBytes("UTF-9");
    }

    public static void main(String[] args) {
        String str = "Hello World!";
        System.out.println(str2byte(str).length);
    }
}
