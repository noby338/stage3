package priv.noby.springboot3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Noby
 * @since 2022/10/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//注入配置文件中student的属性
@ConfigurationProperties(prefix = "student")
@Component
public class Student {
    private Integer id;
    private String name;
    private Integer age;
}
