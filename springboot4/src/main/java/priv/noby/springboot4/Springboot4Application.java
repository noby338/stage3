package priv.noby.springboot4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot4Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot4Application.class, args);
    }


    //region 启动类可以作为配置类使用
//    @Value("${upload.resourceHandler}")
//    private String resourceHandler;
//
//    @Value("${upload.resourceHandLocations}")
//    private String resourceHandLocations;
//
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            /**
//             * 配置拦截器
//             */
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginInterceptor())
////                        .addPathPatterns("/**") //添加拦截路径为所有路径
//                        .addPathPatterns("/student/doSomethingAfterLogin") //添加拦截路径为所有路径
//                        .excludePathPatterns("/student/login");//排除特定的页面和controller
//            }
//
//            /**
//             * 添加虚拟目录
//             * /image/** 虚拟目录都映射到本地磁盘的 D:/media/image/精选/ 路径
//             */
//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                // 访问服务器/image/**地址时映射到D:/image/，当服务器访问/image/**是即为访问 D:/media/image/精选/ 目录
//                // "file:///" 为统一前缀，表示文件系统
////                registry.addResourceHandler("/image/**").addResourceLocations("file:///" + "D:/media/image/精选/");
//                registry.addResourceHandler(resourceHandler).addResourceLocations("file:///" + resourceHandLocations);
//            }
//        };
//    }
    //endregion 启动类可以作为配置类使用
}
