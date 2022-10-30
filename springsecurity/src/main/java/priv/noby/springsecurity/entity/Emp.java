package priv.noby.springsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Emp)实体类
 *
 * @author Noby
 * @since 2022-10-30 14:17:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp implements Serializable {
    private static final long serialVersionUID = 903402907020895581L;
    private Integer id;
    private String name;
    private Integer did;

}

