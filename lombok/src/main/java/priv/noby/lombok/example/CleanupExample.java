package priv.noby.lombok.example;

import lombok.Cleanup;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Cleanup 注解用于自动关闭资源，例如文件流、数据库连接等。通过使用 @Cleanup 注解，可以避免手动关闭资源的繁琐操作，提高代码的简洁性和可读性。
 *
 * 在使用 @Cleanup 注解时，需要注意以下几点：
 *
 * 只能用于局部变量上，不能用于成员变量。
 * 会自动在方法结束时关闭资源，无需手动调用 close() 方法或使用 try-finally 块。
 * 支持的资源类型包括：java.io.Closeable、java.lang.AutoCloseable 和 java.sql.Connection。
 */
public class CleanupExample {
    public static void main(String[] args) throws IOException {
        String inStr = "Hello World!";
        //使用输入输出流自动关闭，无需编写try catch和调用close()方法
        @Cleanup ByteArrayInputStream in = new ByteArrayInputStream(inStr.getBytes("UTF-8"));
        @Cleanup ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            out.write(b, 0, r);
        }
        String outStr = out.toString("UTF-8");
        System.out.println(outStr);
    }
}
