package priv.noby.spring3.service;

import priv.noby.spring3.entity.Student;

public interface StudentService {
    Student selectById(int id);
    boolean insert(Student student);
}
