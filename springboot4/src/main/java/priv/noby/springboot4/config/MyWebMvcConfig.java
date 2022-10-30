package priv.noby.springboot4.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import priv.noby.springboot4.intercepter.LoginInterceptor;

/**
 * 配置类的定义
 *
 * @Configuration 为配置类注解（表示该类为配置类）
 */
@Configuration
public class MyWebMvcConfig {
    @Value("${upload.resourceHandler}")
    private String resourceHandler;

    @Value("${upload.resourceHandLocations}")
    private String resourceHandLocations;

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * 配置拦截器
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
//                        .addPathPatterns("/**") //添加拦截路径为所有路径
                        .addPathPatterns("/student/doSomethingAfterLogin") //添加拦截路径为所有路径
                        .excludePathPatterns("/student/login");//排除特定的页面和controller
            }

            /**
             * 添加虚拟目录
             * /image/** 虚拟目录都映射到本地磁盘的 D:/media/image/精选/ 路径
             */
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                // 访问服务器/image/**地址时映射到D:/image/，当服务器访问/image/**是即为访问 D:/media/image/精选/ 目录
                // "file:///" 为统一前缀，表示文件系统
//                registry.addResourceHandler("/image/**").addResourceLocations("file:///" + "D:/media/image/精选/");
                registry.addResourceHandler(resourceHandler).addResourceLocations("file:///" + resourceHandLocations);
            }
        };
    }

}
