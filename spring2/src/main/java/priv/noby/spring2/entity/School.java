package priv.noby.spring2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
//参数中的"school" 相当于配置文件中的id <bean id="school" class=""/>
//@Component 不写参数默认为类名的小驼峰 即 "school"
@Component("school")
public class School {
    @Value("100")
    private int scId;
    @Value("北京大学")
    private String scName;
}
