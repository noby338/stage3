package priv.noby.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 该类为 SpringBoot 的启动类，自定义的类都放在启动类所在的包及其包下，该路径有默认的包扫描
 * 或者指定 @ComponentScan("") controller 的位置
 * 该注解由这三个注解组成:
 * @Configuration：用于声明Spring中的Java配置；
 * @ComponentScan：启用组件扫描，当我们使用@Component注解声明组件时，会自动发现并注册为Spring应用上下文中的Bean；
 * @EnableAutoConfiguration：开启SpringBoot自动配置功能，简化配置编写。
 *
 * @SpringBootApplication 为启动类注解
 */
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
