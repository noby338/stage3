package priv.noby.notespringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Dep)实体类
 *
 * @author Noby
 * @since 2022-10-30 14:17:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dep implements Serializable {
    private static final long serialVersionUID = 890646778743708220L;
    private Integer id;
    private String name;

}

