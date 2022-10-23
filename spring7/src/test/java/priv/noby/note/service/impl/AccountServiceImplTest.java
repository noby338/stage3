package priv.noby.note.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import priv.noby.note.service.AccountService;


/**
 * 配置文件配置的事务测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountServiceImplTest {
    @Autowired
    @Qualifier("accountServiceImpl")
    private AccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer("noby", "kace",100 );
    }
}