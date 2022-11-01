package priv.noby.notespringboot.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Noby
 * @since 2022/10/30
 */
@SpringBootTest
class RoleDaoTest {
    @Resource
    RoleDao roleDao;

    @Test
    void queryRoleByUserId() {
        System.out.println("roleDao.queryRoleByUserId(1) = " + roleDao.queryRoleByUserId(1));
    }
}