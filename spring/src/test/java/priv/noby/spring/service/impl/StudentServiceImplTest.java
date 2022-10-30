package priv.noby.spring.service.impl;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.noby.spring.service.StudentService;

public class StudentServiceImplTest extends TestCase {
    /**
     * 依赖注入(设值注入)
     * <p>
     * 使用StudentService的selectById()方法需要依赖StudentDao的selectById()，配置实例化StudentServiceImpl的设值注入StudentDaoImpl
     */
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println();
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.selectById(0);
    }

    /**
     * p命名空间依赖注入(设值注入)
     * <p>
     * 使用前 applicationContext.xml 命名空间加入 xmlns:p="http://www.springframework.org/schema/p"
     */
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println();
        StudentService studentService = (StudentService) ac.getBean("studentServiceP");
        studentService.selectById(0);
    }

    /**
     * 依赖注入(构造注入)
     */
    public void test3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println();
        StudentService studentService = (StudentService) ac.getBean("studentServiceConstructor");
        studentService.selectById(0);
    }


    /**
     * 依赖注入引用数据类型的参数名自动注入(设值注入)
     */
    public void test4() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println();
        StudentService studentService = (StudentService) ac.getBean("studentServiceByName");
        studentService.selectById(0);
    }

    /**
     * 依赖注入引用数据类型的参数类型自动注入(设值注入)
     */
    public void test5() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println();
        StudentService studentService = (StudentService) ac.getBean("studentServiceByType");
        studentService.selectById(0);
    }

}