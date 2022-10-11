package priv.noby.note.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import priv.noby.note.config.SpringConfig;
import priv.noby.note.entity.Student;
import priv.noby.note.service.impl.StudentServiceImpl;

public class StudentServiceTest {

    private ApplicationContext applicationContext;
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        studentService = (StudentServiceImpl) applicationContext.getBean("studentServiceImpl");
    }

    @Test
    public void testFindStudent() {
        Student student = studentService.selectById(1);
        System.out.println(student);
    }

    @Test
    public void testAddStudent() {
    }
}