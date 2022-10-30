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

// MapperScannerConfigxxx:扫描指定包下所有的接口，然后所有接口在编译之后都会生成相应的实现类，该注解可代替mapper接口的@Mapper的注解
@MapperScan("priv.noby.springboot2.dao")
// 配置注解驱动
@EnableTransactionManagement
@SpringBootApplication
public class Springboot2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2Application.class, args);
    }

}
