package priv.noby.spring3.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.noby.spring3.entity.Student;

public class StudentDaoTest {

    private ApplicationContext applicationContext;
    private StudentDao studentDao;
 
//    @Before
//    public void setUp(){
//        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        studentDao = (StudentDao) applicationContext.getBean("studentDao");
//    }
    @Test
    public void Test2() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("applicationContext = " + applicationContext);
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