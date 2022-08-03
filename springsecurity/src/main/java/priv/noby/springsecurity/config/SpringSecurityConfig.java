package priv.noby.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
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
import priv.noby.springsecurity.exception.AccessDeniedHandlerImpl;
import priv.noby.springsecurity.exception.AuthenticationEntryPointImpl;
import priv.noby.springsecurity.filter.JwtAuthenticationFilter;

/**
 * SpringSecurity 的配置类
 * @EnableGlobalMethodSecurity 启用授权
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
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
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用跨站请求伪造，前后端分离的程序没有这种问题response
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//session 失效
                .and()//表示返回 http 对象(继续链式编程)
                .authorizeRequests()
                .antMatchers("/login").anonymous()//login 可以没有认证访问，有 token 不能访问
                .anyRequest().authenticated();    //其它请求要认证，没有 token 不能访问

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); //使该过滤器在框架的过滤器之前执行该过滤器

        http.exceptionHandling()
                //配置自定义认证异常处理
                .authenticationEntryPoint(new AuthenticationEntryPointImpl())
                //配置自定义授权异常处理
                .accessDeniedHandler(new AccessDeniedHandlerImpl());

        //SpringSecurity 允许跨域访问
        http.cors();
    }
}
