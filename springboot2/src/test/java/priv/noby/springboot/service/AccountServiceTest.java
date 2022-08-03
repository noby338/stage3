package priv.noby.springboot.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    AccountService accountService;
    @Test
    public void testTransfer() {
        accountService.transfer("noby", "kace",100 );
    }
}