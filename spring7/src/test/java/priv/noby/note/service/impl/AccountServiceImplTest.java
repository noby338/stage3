package priv.noby.note.service.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.noby.note.service.AccountService;

public class AccountServiceImplTest {

    @Test
    public void testTransfer() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountServiceImpl");
        accountService.transfer("noby", "kace",100 );
    }
}