package priv.noby.spring3.dao;

import priv.noby.spring3.entity.Student;

public interface StudentDao {
    Student selectById(int id);
    boolean insert(Student student);
}
