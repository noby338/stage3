package priv.noby.springboot2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 该类为 SpringBoot 的启动类，自定义的类都放在启动类所在的包及其包下，该路径有默认的包扫描
 * 或者指定 @ComponentScan("") controller 的位置
 *
 * @SpringBootApplication 为启动类注解
 */

// 配置包扫描，创建该包下接口的实现类
@MapperScan("priv.noby.springboot2.dao")
// 配置注解驱动
@EnableTransactionManagement
@SpringBootApplication
public class Springboot2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2Application.class, args);
    }

}
