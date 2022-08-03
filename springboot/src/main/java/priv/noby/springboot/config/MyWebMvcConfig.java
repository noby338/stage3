package priv.noby.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import priv.noby.springboot.interceptor.LoginInterceptor;

/**
 * @Configuration 为配置类注解（表示该类为配置类）
 */
@Configuration
public class MyWebMvcConfig {
    @Value("${upload.resourceHandler}")
    private String resourceHandler;
    @Value("${upload.resourceHandLocations}")
    private String resourceLocations;
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            /**
             * 配置请求路径的转换（可使访问静态资源时的路径转换到动态资源路径）
             */
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/a.html").setViewName("/a.html");
                registry.addViewController("/login.html").setViewName("/login.html");
                registry.addViewController("/upload.html").setViewName("/upload.html");
            }

            /**
             * 配置拦截器
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        .addPathPatterns("/**") //添加拦截路径为所有路径
                        .excludePathPatterns("/login.html","/login","/a.html",
                                "/thymeleaf.html","/date","/upload.html","/upload");//排除特定的页面
            }

            /**
             * 添加虚拟目录
             * /image/** 虚拟目录都映射到本地磁盘的 D:/image/ 路径
             */
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                // "file:///" 为统一前缀，表示文件系统
//                registry.addResourceHandler("/image/**").addResourceLocations("file:///"+"D:/image/");
                // 使用配置文件
                registry.addResourceHandler(resourceHandler).addResourceLocations("file:///"+resourceLocations);
            }
        };
    }

}
