package priv.noby.spring2.entity;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class StudentTest {
    @Test
    public void student() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //该方法判断是否存在某个对象
        Student student = (Student) applicationContext.getBean("student");
        Student student2 = (Student) applicationContext.getBean("student");
        System.out.println("这是单例模式吗？" + (student == student2));
        System.out.println("student = " + student);
        //虚拟机关闭之前自动执行 close() 方法(回调函数)(用于查看destroy方法)
        ((ClassPathXmlApplicationContext) applicationContext).registerShutdownHook();

    }

}