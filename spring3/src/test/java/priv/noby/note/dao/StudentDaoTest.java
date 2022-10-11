package priv.noby.note.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.noby.note.entity.Student;

public class StudentDaoTest {

    private ApplicationContext applicationContext;
    private StudentDao studentDao;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentDao = (StudentDao) applicationContext.getBean("studentDao");
    }
    @Test
    public void testSelectById() {
        Student student = studentDao.selectById(1);
        System.out.println("student = " + student);
    }

    @Test
    public void testInsert() {
        Student student = new Student();
        student.setName("noby");
        student.setAge(20);
        boolean b = studentDao.insert(student);
        System.out.println(b);
    }

}