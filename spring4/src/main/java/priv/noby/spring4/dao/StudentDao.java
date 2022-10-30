package priv.noby.spring4.dao;

import priv.noby.spring4.entity.Student;

public interface StudentDao {
    Student selectById(int id);
    boolean insert(Student student);
}
