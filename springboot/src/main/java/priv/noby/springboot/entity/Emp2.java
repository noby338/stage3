package priv.noby.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
//这个注解就是告诉系统，将配置文件中以 emp 的属性，赋值给当前对象对应的属性值(该注解一般为系统类使用)
@ConfigurationProperties(prefix = "emp")
public class Emp2 {
    private Integer eid;
    private String ename;
    private Dep dep;
}
