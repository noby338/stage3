package priv.noby.springsecurity2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import priv.noby.springsecurity2.filter.JwtAuthenticationFilter;

import javax.annotation.Resource;

/**
 * SpringSecurity 的配置类
 *
 */
//启用授权
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    JwtAuthenticationFilter jwtAuthenticationFilter;
    /**
     * 启用密码加密
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置认证管理器，供 LoginServiceImpl 账户认证使用
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 配置过滤拦截，配置后，自己的 login 将代替框架的 login
     * 配置登录过滤器的执行时机
     * 配置认证异常和授权异常处理
     * 配置跨域访问
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//禁用跨站请求伪造，前后端分离的程序没有这种问题
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//不使用session

        http.authorizeRequests()
//                .antMatchers("/user/login").permitAll()//有没有认证都可以访问，用于单体项目对静态资源放行
                .antMatchers("/user/login").anonymous()// /user/login 没有认证可以访问，有 token 不能访问
                .anyRequest().authenticated();   //其它请求要认证，没有 token 不能访问

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); //使该过滤器在框架的过滤器之前执行该过滤器

//        http.exceptionHandling()
//                //配置自定义认证异常处理
//                .authenticationEntryPoint(new AuthenticationEntryPointImpl())
//                //配置自定义授权异常处理
//                .accessDeniedHandler(new AccessDeniedHandlerImpl());
//
//        //SpringSecurity 允许跨域访问
//        http.cors();
    }
}
