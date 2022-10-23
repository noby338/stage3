package priv.noby.springboot2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.noby.springboot2.constant.Constant;

import javax.sql.DataSource;

@SpringBootTest
// 该注解为 lombok 的注解，用于输出日志（自动创建日志对象）
@Slf4j
public class Springboot2ApplicationTests {
    @Autowired
    DataSource dataSource;

    /**
     * 查看数据源
     * 默认为 springboot 自带的 HikariDataSource
     * 可配置第三方数据源 druid
     */
    @Test
    void contextLoads2() {
        System.out.println("dataSource = " + dataSource);
    }

    /**
     * 测试数据共享
     */
    @Test
    void contextLoads3() {
        System.out.println("Constant.INFO = " + Constant.INFO);
    }

}
