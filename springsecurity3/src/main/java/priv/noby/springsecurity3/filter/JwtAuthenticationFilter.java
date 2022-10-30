package priv.noby.springsecurity3.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import priv.noby.springsecurity3.dao.UserDao;
import priv.noby.springsecurity3.entity.User;
import priv.noby.springsecurity3.entity.UserDetail;
import priv.noby.springsecurity3.util.JwtUtil;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义Filter实现token拦截验证(判断用户是否登录)
 *
 * 该类过滤器的使用只需实现OncePerRequestFilter接口，无需配置
 * <p>
 * 为了是认证过滤器在springsecurity的filter和interceptor之前执行，使用filter而非interceptor(filter优先级高)
 * 该filter在配置类中配置后，在其他springsecurity自带filter之前执行
 * 实现OncePerRequestFilter可保证一次请求只经过一次过滤器(Filter在多次转发会执行多次)
 * 该OncePerRequestFilter中的异常不能由自定义全局异常捕获，系统的认证异常执行优先权高于全局异常，因此将由系统的认证异常捕获
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Resource
    UserDao userDao;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("JwtAuthenticationFilter.doFilterInternal");
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            //没有token，放行，放行后将执行springsecurity的拦截器和过滤器，springsecurity中没有authentication将会抛出认证异常
            filterChain.doFilter(request, response);
        } else if (!JwtUtil.verify(token)) {
            //token无效，抛出异常，认证异常类将处理该异常
            throw new RuntimeException("jwt过滤器，无效token");
        } else {
            //token有效,解析token
            String username = JwtUtil.getUsername(token);
            //获取完整的用户信息，若有缓存，可以去缓存中获取
            User user = userDao.queryByUsername(username);
            //Object principal, 身份信息    完整用户信息
            //Object credentials,凭证    即为UserDetail，因为当user确定，其确定，因此不用传
            //Collection<? extends GrantedAuthority> authorities 授权信息
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, new UserDetail(user).getAuthorities());
            //当springsecurity上下文中存在该authentication后，后面的springsecurity的Filter不会再拦截这个请求
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        }
    }
}
