package priv.noby.springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SpringSecurityApplicationTests {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        System.out.println("passwordEncoder.encode(\"aa\") = " + passwordEncoder.encode("aa"));
        System.out.println("passwordEncoder.encode(\"aa\") = " + passwordEncoder.encode("aa"));
        System.out.println(passwordEncoder.matches("aa", "$2a$10$2Ww0B0msJ0LzBwjU/R5fK.mSBFDmJFfnP0llSRSRoJiX4beLZ1jDC"));
        System.out.println(passwordEncoder.matches("aa", "$2a$10$R4tiAa7IaXZjF9wMujAMre/L4aifkDBJG/LPY6pgEksxO7ylp4Cey"));

    }

}
