package priv.noby.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Dep {
    @Value("${emp.dep.did}")
    private Integer did;
    @Value("${emp.dep.dname}")
    private String dname;

    private List<Emp> emps;
}
