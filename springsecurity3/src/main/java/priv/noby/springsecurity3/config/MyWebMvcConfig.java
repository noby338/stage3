//package priv.noby.springsecurity3.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
///**
// * web中跨域相关的配置
// */
//@Configuration
//public class MyWebMvcConfig {
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            /**
//             * 跨域映射，跨域的全局配置
//             *
//             * 添加该配置后，后端响应给浏览器的响应头中会携带，Access-Control-Allow-Origin头，如此浏览器不再绝收该响应
//             */
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")//允许跨域的接口(controller)
//                        .allowedOrigins("*")//允许可以访问的域(前端)
//                        .allowCredentials(true)//允许来自其他域携带凭证，Cookie存在此凭证中(配合前端main.js 的 axios.defaults.withCredentials = true;)
//                        .allowedMethods("*")//允许跨域的请求类型 post get put delete
//                        .allowedHeaders("*")//允许传递请求头
//                        .maxAge(3600);//允许跨域的作用时间(该时间内只跨域一次即有效)，单位为秒，默认为 1800
//                //OPTION探测请求为put或post请求之前执行的一次请求，查看服务器是否支持put请求
//            }
//
//        };
//    }
//
//}
