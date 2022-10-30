package priv.noby.springsecurity3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * (Role)实体类
 *
 * @author Noby
 * @since 2022-10-30 14:48:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = 445803494948329577L;
    private Integer id;
    private String name;
    private List<Permission> PermissionList;

}

