package priv.noby.spring7.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import priv.noby.spring7.service.AccountService;

/**
 * 注解配置的事务测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-anno.xml")
public class AccountServiceImpl2Test {
    @Autowired
    @Qualifier("accountServiceImpl2")
    private AccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer("noby", "kace",100 );
    }
}