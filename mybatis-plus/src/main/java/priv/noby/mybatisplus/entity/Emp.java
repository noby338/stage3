package priv.noby.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工
 *
 * @author Noby
 * @since 2023/7/11
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("emp")
public class Emp {
    //id的增长策略，设置为自增长，可在配置文件中配置全局策略(默认为IdType.NONE)
//    @TableId(type = IdType.AUTO)
    private Integer id;
    //当数据库中的字段名和实体类中的属性名不一致时，可以通过@TableField注解来指定数据库中的字段名(驼峰命名无需指定，可自动映射)
//    @TableField("name")
    private String name;
    //指定该属性不映射到数据库的字段(实体中的数据不会作为值插入到数据库)
//    @TableField(exist = false)
    //指定数据库查询该字段时，不会将该数据自动填充到该实体属性中(通常用于密码保护)
//    @TableField(select = false)
    //指定该属性在插入数据时，自动填充数据(通常用于创建时间)，还需要配置MyMetaObjectHandler类并注入
    @TableField(fill = FieldFill.INSERT)
    private Integer did;
}
