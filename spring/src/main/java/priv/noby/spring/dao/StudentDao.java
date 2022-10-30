package priv.noby.spring.dao;

import priv.noby.spring.entity.Student;

/**
 * @author Noby
 * @since 2022/10/8
 */
public interface StudentDao {
    Student selectById(int id);
}
