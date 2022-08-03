package priv.noby.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 该类为 SpringBoot 的启动类，自定义的类都放在启动类所在的包及其包下，该路径有默认的包扫描
 * 或者指定 @ComponentScan("") controller 的位置
 *
 * @SpringBootApplication 为启动类注解
 */

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
