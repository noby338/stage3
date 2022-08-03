package priv.noby.note.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.noby.note.entity.Student;
import priv.noby.note.service.StudentService;

import java.util.Date;

public class StudentServiceImplTest {

    private ApplicationContext applicationContext;
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = (StudentService) applicationContext.getBean("studentService");

    }
    @Test
    public void testFindStudent() {
        Student student = studentService.findStudent(2022001);
        System.out.println("student = " + student);
    }

    @Test
    public void testAddStudent() {
        Student student = new Student();
        student.setName("noby2");
        student.setGender("m");
        student.setBirthday(new Date());
        boolean b = studentService.addStudent(student);
        System.out.println(b);
    }

}