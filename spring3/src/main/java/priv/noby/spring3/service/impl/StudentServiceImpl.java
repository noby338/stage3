package priv.noby.spring3.service.impl;

import priv.noby.spring3.dao.StudentDao;
import priv.noby.spring3.entity.Student;
import priv.noby.spring3.service.StudentService;

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
