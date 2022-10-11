package priv.noby.note.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
//参数中的"school" 相当于配置文件中的id <bean id="school" class="priv.noby.note.entity.School"/>
//@Component 不写参数默认为类名的小驼峰 即 "school"
@Component("school")
public class School {
    @Value("100")
    private int scId;
    @Value("蜗牛大学")
    private String scName;
}
