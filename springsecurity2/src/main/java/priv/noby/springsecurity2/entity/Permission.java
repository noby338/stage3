package priv.noby.springsecurity2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Permission)实体类
 *
 * @author Noby
 * @since 2022-10-30 14:48:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission implements Serializable {
    private static final long serialVersionUID = -85215752469119211L;
    private Integer id;
    private String name;

}

