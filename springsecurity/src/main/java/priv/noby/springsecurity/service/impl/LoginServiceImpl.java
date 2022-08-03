package priv.noby.springsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import priv.noby.springsecurity.entity.User;
import priv.noby.springsecurity.service.LoginService;
import priv.noby.springsecurity.util.JwtUtil;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public String login(User user) {
        //将前端输入的账号密码封装成Authentication
        Authentication authentication=
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        //通过AuthenticationManager调用认证方法：
        //底层UsernamePasswordAuthenticationToken和LoginUserDetail会比较，判断是否登录成功
        //认证失败，底层会抛出异常
        Authentication authenticate = authenticationManager.authenticate(authentication);
        //没有异常，登录成功
        //登录成功，可以将用户信息存入缓存，userid或username作为可以，LoginUserDetail作为value
        //getPrincipal()认证成功以后的身份信息，就是LoginUserDetail
        System.out.println("登录成功getPrincipal():"+authenticate.getPrincipal());
        return JwtUtil.create(user.getUsername());
    }
}
