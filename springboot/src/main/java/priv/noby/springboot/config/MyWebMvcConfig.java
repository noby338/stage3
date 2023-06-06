package priv.noby.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 为配置类注解（表示该类为配置类）
 */
@Configuration
public class MyWebMvcConfig {
    @Value("${server.port}")
    private String port;
    @Value("${info}")
    private String info;
    @Bean
    public void webMvcConfigurer(){
        System.out.println("servet.port = " + port);
        System.out.println("info = " + info);
    }
}
