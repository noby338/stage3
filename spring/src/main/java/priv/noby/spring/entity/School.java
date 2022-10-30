package priv.noby.spring.entity;

import lombok.Data;

@Data
public class School {
    private int scId;
    private String scName;

    public School() {
        System.out.println("School.School 无参构造");
    }

    public School(int scId, String scName) {
        this.scId = scId;
        this.scName = scName;
        System.out.println("School.School 有参构造");
    }
}
