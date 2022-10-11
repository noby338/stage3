package priv.noby.note.dao.impl;

import priv.noby.note.dao.StudentDao;
import priv.noby.note.entity.Student;

/**
 * @author Noby
 * @since 2022/10/8
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public Student selectById(int id) {
        System.out.println("StudentDaoImpl.selectById");
        return null;
    }
}
