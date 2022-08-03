package priv.noby.note.service;

import priv.noby.note.entity.Student;

public interface StudentService {
    Student findStudent(int id);
    boolean addStudent(Student student);
}
