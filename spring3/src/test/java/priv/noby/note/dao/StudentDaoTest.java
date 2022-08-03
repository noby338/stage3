package priv.noby.note.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.noby.note.entity.Student;

import java.util.Date;

import static org.junit.Assert.*;

public class StudentDaoTest {

    private ApplicationContext applicationContext;
    private StudentDao studentDao;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        studentDao = (StudentDao) applicationContext.getBean("studentDao");
    }
    @Test
    public void testSelectById() {
        Student student = studentDao.selectById(2022001);
        System.out.println("student = " + student);
    }

    @Test
    public void testInsert() {
        Student student = new Student();
        student.setName("noby2");
        student.setGender("m");
        student.setBirthday(new Date());
        boolean b = studentDao.insert(student);
        System.out.println(b);
    }

}