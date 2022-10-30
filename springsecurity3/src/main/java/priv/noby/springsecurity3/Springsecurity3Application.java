package priv.noby.springsecurity3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("priv.noby.springsecurity3.dao")
@SpringBootApplication
public class Springsecurity3Application {

    public static void main(String[] args) {
        SpringApplication.run(Springsecurity3Application.class, args);
    }

}
