package priv.noby.spring.service;

import priv.noby.spring.entity.Student;

public interface StudentService {
    void show();

    Student selectById(int id);
}
