package priv.noby.spring4.service;

import priv.noby.spring4.entity.Student;

public interface StudentService {
    Student selectById(int id);
    boolean insert(Student student);
}
