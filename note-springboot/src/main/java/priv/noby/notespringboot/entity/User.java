package priv.noby.notespringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * (User)实体类
 *
 * @author Noby
 * @since 2022-10-30 14:48:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -40319347469399732L;
    private Integer id;
    private String username;
    private String password;
    private List<Role> RoleList;

}

