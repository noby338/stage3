package priv.noby.spring.dao.impl;

import priv.noby.spring.dao.StudentDao;
import priv.noby.spring.entity.Student;

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
