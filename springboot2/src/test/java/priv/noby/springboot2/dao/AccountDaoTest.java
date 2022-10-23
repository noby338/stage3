package priv.noby.springboot2.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import priv.noby.springboot2.entity.Account;

import javax.annotation.Resource;


/**
 * 测试mybatis是否整合成功
 *
 * @author Noby
 * @since 2022/10/23
 */
@SpringBootTest
public class AccountDaoTest {
    @Resource
    AccountDao accountDao;

    @Test
    public void selectByName() {
        Account noby = accountDao.selectByName("noby");
        System.out.println("noby = " + noby);
    }
}