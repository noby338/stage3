package priv.noby.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Some {
    private String[] strArr;
    private Student[] studentArr;
    private List<String> strList;
    private List<Student> stuList;
    private Set<String> strSet;
    private Map<String,String> strMap;
    private Map<Student,Student> studentStudentMap;
    private Properties properties;
}


