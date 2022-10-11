package priv.noby.note.dao;

import priv.noby.note.entity.Student;

/**
 * @author Noby
 * @since 2022/10/8
 */
public interface StudentDao {
    Student selectById(int id);
}
