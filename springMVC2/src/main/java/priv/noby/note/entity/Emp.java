package priv.noby.note.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp implements Serializable {
    private Integer eid;
    private String ename;
    //这个注解用于SpringMVC封装成对象时的日期格式化
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date hiredate;
    //域属性
    private Dep dep;


    public Emp(Integer eid, String ename, Date hiredate) {
        this.eid = eid;
        this.ename = ename;
        this.hiredate = hiredate;
    }
}
