package priv.noby.vuespringboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import priv.noby.vuespringboot.interceptor.LoginInterceptor;

/**
 * @Configuration 为配置类注解（表示该类为配置类）
 */
@Configuration
public class MyWebMvcConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * 跨域的全局配置
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")//运行跨域
                        .allowCredentials(true)//运行携带凭证，Cookie
                        .allowedMethods("*")//允许跨域的请求类型 post get put delete
                        .allowedHeaders("*")//允许传递请求头
                        .maxAge(3600);//允许跨域的作用时间(该时间内之跨域一次即有效)，单位为秒，默认为 1800
            }

            /**
             * 添加拦截器
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        .addPathPatterns("/**").
                        excludePathPatterns("/login");
//                        .addPathPatterns("/**");
            }
        };
    }

}
