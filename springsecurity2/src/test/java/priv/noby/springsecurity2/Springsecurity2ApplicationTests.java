package priv.noby.springsecurity2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SpringSecurity2ApplicationTests {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        //该加密算法没次生成的加密可能不一样，但不影响验证
        System.out.println("passwordEncoder.encode(\"aaa\") = " + passwordEncoder.encode("aaa"));
        System.out.println("passwordEncoder.encode(\"aaa\") = " + passwordEncoder.encode("aaa"));
        System.out.println(passwordEncoder.matches("aaa", "$2a$10$RI7Q2M/.tALqgsOYcxJKAOqzMj3niLvBT1Qxvk4AY.n3kdfcj2fT2"));
        System.out.println(passwordEncoder.matches("aaa", "$2a$10$NJ706NQeuugO3TODL0uFQehPQFdOqFUAOfgWscQnxyuB1b9lmekU6"));
        System.out.println("passwordEncoder.encode(\"123\") = " + passwordEncoder.encode("123"));
    }

}
