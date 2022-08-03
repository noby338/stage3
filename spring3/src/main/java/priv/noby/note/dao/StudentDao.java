package priv.noby.note.dao;

import priv.noby.note.entity.Student;

public interface StudentDao {
    Student selectById(int id);
    boolean insert(Student student);
}
