package priv.noby.note.service;

import priv.noby.note.entity.Student;

public interface StudentService {
    Student selectById(int id);
    boolean insert(Student student);
}
