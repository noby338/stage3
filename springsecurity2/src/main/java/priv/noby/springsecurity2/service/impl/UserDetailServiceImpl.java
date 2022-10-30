package priv.noby.springsecurity2.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import priv.noby.springsecurity2.dao.UserDao;
import priv.noby.springsecurity2.entity.User;
import priv.noby.springsecurity2.entity.UserDetail;

import javax.annotation.Resource;

/**
 * 该类的作用准备用户登录验证用的信息，其信息来自数据库
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    UserDao userDao;

    /**
     * @param username 来自用户输入的用户名
     * @return UserDetails 根据用户名查找到该用户在数据库的正确信息，并封装为UserDetails对象
     * @throws UsernameNotFoundException 根据用户名无法查找到该用户时抛出异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("UserDetailServiceImpl.loadUserByUsername");
//            user=new User("a", "{noop}aa");//使用明文密码必须加上{noop}前缀，否则报错
        User user = userDao.queryByUsername(username);
        System.out.println("user = " + user);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return new UserDetail(user);
    }
}
