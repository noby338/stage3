package priv.noby.note.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dep {
    private Integer did;
    private String dname;
    private List<Emp> emps;
}
