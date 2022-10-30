package priv.noby.springsecurity.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import priv.noby.springsecurity.entity.User;
import priv.noby.springsecurity.service.LoginService;
import priv.noby.springsecurity.util.JwtUtil;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    AuthenticationManager authenticationManager;

    @Override
    public String login(User user) {
        //Object principal 身份信息(用户名)
        //Object credentials 凭证(密码)
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        //底层UsernamePasswordAuthenticationToken和UserDetail会比较，判断是否登录成功，若认证失败，底层会抛出异常
        Authentication authenticate = authenticationManager.authenticate(authentication);
        //此处登录成功，可以将用户信息存入缓存，userid或username作为key，UserDetail作为value
        //getPrincipal()认证成功以后的身份信息，就是UserDetail
        System.out.println("authenticate.getPrincipal() = " + authenticate.getPrincipal());
        return JwtUtil.create(user.getUsername());
    }
}
