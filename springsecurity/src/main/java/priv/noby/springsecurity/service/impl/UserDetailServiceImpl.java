package priv.noby.springsecurity.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import priv.noby.springsecurity.entity.LoginUserDetail;
import priv.noby.springsecurity.entity.User;

import java.util.Arrays;
import java.util.List;

/**
 * 该类的作用准备用户登录验证用的信息，其信息来自数据库
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        //启用了授权，查询用户的时候，要查询用户对应的权限
        List<String> permissions;
        //根据用户名去数据库查询
        if ("a".equals(username)) {
//            user=new User("a", "{noop}aaa");//使用明文密码
            user = new User("a", "$2a$10$2Ww0B0msJ0LzBwjU/R5fK.mSBFDmJFfnP0llSRSRoJiX4beLZ1jDC");
            permissions = Arrays.asList("t");
        } else if ("b".equals(username)) {
            user = new User("b", "$2a$10$R4tiAa7IaXZjF9wMujAMre/L4aifkDBJG/LPY6pgEksxO7ylp4Cey");
            permissions = Arrays.asList("t2","t3");
        } else {
            throw new RuntimeException("用户名不存在");
        }
        //返回UserDetails对象
        return new LoginUserDetail(user,permissions);
    }
}
