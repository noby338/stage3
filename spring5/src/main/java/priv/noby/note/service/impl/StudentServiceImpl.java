package priv.noby.note.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.noby.note.dao.StudentDao;
import priv.noby.note.entity.Student;
import priv.noby.note.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public Student findStudent(int id) {
        return studentDao.selectById(id);
    }

    @Override
    public boolean addStudent(Student student) {
        return studentDao.insert(student);
    }

}
