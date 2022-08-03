package priv.noby.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Emp {
    @Value("${emp.eid}")
    private Integer eid;
    @Value("${emp.ename}")
    private String ename;
    @Autowired
    private Dep dep;
}
