package priv.noby.note.service.impl;

import priv.noby.note.dao.StudentDao;
import priv.noby.note.entity.Student;
import priv.noby.note.service.StudentService;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student selectById(int id) {
        return studentDao.selectById(id);
    }

    @Override
    public boolean insert(Student student) {
        return studentDao.insert(student);
    }

}
