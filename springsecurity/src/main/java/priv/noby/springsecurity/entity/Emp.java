package priv.noby.springsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer eid;
    private String ename;
    private Date hiredate;
    private Dep dep;
}
