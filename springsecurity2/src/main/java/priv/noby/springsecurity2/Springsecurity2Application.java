package priv.noby.springsecurity2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("priv.noby.springsecurity2.dao")
@SpringBootApplication
public class Springsecurity2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springsecurity2Application.class, args);
    }

}
