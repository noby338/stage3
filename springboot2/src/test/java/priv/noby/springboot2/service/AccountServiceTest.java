package priv.noby.springboot2.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试事务是否成功
 */
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    AccountService accountService;
    @Test
    public void testTransfer() {
        accountService.transfer("noby", "kace",100 );
    }
}