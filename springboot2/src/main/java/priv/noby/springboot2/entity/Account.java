package priv.noby.springboot2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer id;
    private String name;
    private Integer money;
}
