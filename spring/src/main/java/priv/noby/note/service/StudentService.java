package priv.noby.note.service;

import priv.noby.note.entity.Student;

public interface StudentService {
    void show();

    Student selectById(int id);
}
