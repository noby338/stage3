package priv.noby.springsecurity.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Noby
 * @since 2022/10/30
 */
@SpringBootTest
class UserDaoTest {
    @Resource
    UserDao userDao;

    @Test
    void queryByUsername() {
        System.out.println("userDao.queryByUsername(\"noby\") = " + userDao.queryByUsername("noby"));
    }
}