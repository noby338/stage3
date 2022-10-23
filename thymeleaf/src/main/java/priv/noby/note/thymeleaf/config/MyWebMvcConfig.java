package priv.noby.note.thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Configuration 为配置类注解（表示该类为配置类）
 */
@Configuration
public class MyWebMvcConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            /**
             * 配置请求路径的转换（可使访问静态资源时的路径转换到动态资源路径）
             */
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/a.html").setViewName("/a.html");
            }
        };
    }

}
