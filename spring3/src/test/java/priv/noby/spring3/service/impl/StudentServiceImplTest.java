package priv.noby.spring3.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.noby.spring3.entity.Student;
import priv.noby.spring3.service.StudentService;

public class StudentServiceImplTest {

    private ApplicationContext applicationContext;
    private StudentService studentService;

    @Before
    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = (StudentService) applicationContext.getBean("studentService");

    }
    @Test
    public void testSelectById() {
        Student student = studentService.selectById(1);
        System.out.println("student = " + student);
    }

    @Test
    public void testInsert() {
        Student student = new Student();
        student.setName("kace");
        student.setAge(30);
        boolean b = studentService.insert(student);
        System.out.println(b);
    }
}