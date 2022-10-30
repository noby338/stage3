package priv.noby.ssm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dep {
    private Integer id;
    private String name;
    private List<Emp> empList;
}
