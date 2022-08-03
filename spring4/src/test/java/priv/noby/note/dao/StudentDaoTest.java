package priv.noby.note.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import priv.noby.note.config.SpringConfig;
import priv.noby.note.entity.Student;

public class StudentDaoTest {

    private ApplicationContext applicationContext;
    private StudentDao studentDao;

    @Before
    public void setUp() throws Exception {
        applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        studentDao = (StudentDao) applicationContext.getBean("studentDao");
    }

    @Test
    public void testSelectById() {
        Student student = studentDao.selectById(2022001);
        System.out.println(student);
    }
}