package priv.noby.notespringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("priv.noby.notespringboot.dao")
@SpringBootApplication
public class NoteSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(NoteSpringbootApplication.class, args);
    }
}