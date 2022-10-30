package priv.noby.springsecurity2.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import priv.noby.springsecurity2.dao.UserDao;
import priv.noby.springsecurity2.entity.User;
import priv.noby.springsecurity2.entity.UserDetail;
import priv.noby.springsecurity2.util.JwtUtil;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//自定义Filter实现token拦截验证
//该filter在其他springsecurity自带filter之前执行(在配置类中配置)
//实现OncePerRequestFilter可保证一次请求只经过一次过滤器(Filter在多次转发会执行多次)
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Resource
    UserDao userDao;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("JwtAuthenticationFilter.doFilterInternal");
        //获取token
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            //没有token，放行，放行后将执行springsecurity的拦截器
            filterChain.doFilter(request, response);
            return;
        } else if(!JwtUtil.verify(token)){
            //token无效，抛出异常，框架会处理异常
            throw new RuntimeException("无效token");
        }
        //token有效,解析token
        String username = JwtUtil.getUsername(token);
        //获取完整的用户信息:有缓存,可以去缓存中获取
        //现在还是去数据库查询
        User user = userDao.queryByUsername(username);
        //根据用户名去数据库查询
        if(user == null) {
            throw new RuntimeException("用户名不存在");
        }
        //通过token认证以后，告诉框架，该请求已经通过认证，后面的springsecurity的Filter不会再拦截这个请求
        //Object principal, 身份信息    完整用户信息
        //Object credentials,凭证
        //Collection<? extends GrantedAuthority> authorities 授权信息
        Authentication authentication=new UsernamePasswordAuthenticationToken(user, null, new UserDetail(user).getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
