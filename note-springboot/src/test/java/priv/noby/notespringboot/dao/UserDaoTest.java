package priv.noby.notespringboot.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

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