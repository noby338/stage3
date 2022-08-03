package priv.noby.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Emp3 {
    private Integer eid;
    private String ename;
    private Date date;
    private Dep dep;
}
