package priv.noby.spring.service.impl;

import priv.noby.spring.dao.StudentDao;
import priv.noby.spring.entity.Student;
import priv.noby.spring.service.StudentService;

/**
 * 依赖注入
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public StudentServiceImpl() {
        System.out.println("StudentServiceImpl.StudentServiceImpl 无参构造");
    }

    /**
     * 构造注入将调用该方法
     * @param studentDao
     */
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
        System.out.println("StudentServiceImpl.StudentServiceImpl 有参构造");
    }

    /**
     * 设值注入将调用该方法
     * @param studentDao
     */
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
        System.out.println("StudentServiceImpl.setStudentDao");
    }

    @Override
    public void show() {
        System.out.println("StudentServiceImpl.show");
    }

    @Override
    public Student selectById(int id) {
        System.out.println("StudentServiceImpl.selectById");
        return studentDao.selectById(0);
    }
}
