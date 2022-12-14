package priv.noby.spring4.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import priv.noby.spring4.config.SpringConfiguration;
import priv.noby.spring4.entity.Student;
import priv.noby.spring4.service.impl.StudentServiceImpl;

public class StudentServiceTest {

    private ApplicationContext applicationContext;
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {
        //使用ClassPathXmlConfigApplicationContext类加载配置文件，AnnotationConfigApplicationContext类加载配置类
        applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        studentService = (StudentServiceImpl) applicationContext.getBean("studentServiceImpl");
    }

    @Test
    public void testSelectById() {
        Student student = studentService.selectById(1);
        System.out.println(student);
    }

    @Test
    public void testInsert() {
    }
}