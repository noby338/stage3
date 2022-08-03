package priv.noby.springsecurity.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import priv.noby.springsecurity.entity.LoginUserDetail;
import priv.noby.springsecurity.entity.User;
import priv.noby.springsecurity.util.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


//自定义Filter实现token拦截验证
//实现OncePerRequestFilter:保证一次请求只经过一次过滤器
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("JwtAuthenticationFilter.doFilterInternal");
        //获取token
        String token = request.getHeader("token");
        //没有token，放行
        if(StringUtils.isEmpty(token)){
            filterChain.doFilter(request, response);
            return;
        }
        //有token,验证token
        //token无效，抛出异常，框架会处理异常
        if(!JwtUtil.verify(token)){
            throw new RuntimeException("无效token");
        }
        //token有效,解析token
        String username = JwtUtil.getUsername(token);
        //获取完整的用户信息:有缓存,可以去缓存中获取
        //现在还是去数据库查询
        User user;
        List<String> permissions;
        //根据用户名去数据库查询
        if("a".equals(username)){
            user=new User("a","$2a$10$2Ww0B0msJ0LzBwjU/R5fK.mSBFDmJFfnP0llSRSRoJiX4beLZ1jDC");
            permissions = Arrays.asList("t");
        }else if("b".equals(username)){
            user=new User("b","$$2a$10$2Ww0B0msJ0LzBwjU/R5fK.mSBFDmJFfnP0llSRSRoJiX4beLZ1jDC");
            permissions = Arrays.asList("t2","t3");
        }else{
            throw new RuntimeException("用户名不存在");
        }
        //通过token认证以后，告诉框架，现在的请求已经通过认证，后面的Filter不会再拦截这个请求
        //Object principal, 身份信息    完整用户信息
        // Object credentials,凭证
        //Collection<? extends GrantedAuthority> authorities 授权信息
        Authentication authentication=new UsernamePasswordAuthenticationToken(user, null,new LoginUserDetail(user, permissions).getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
