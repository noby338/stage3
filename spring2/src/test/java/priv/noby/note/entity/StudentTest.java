package priv.noby.note.entity;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class StudentTest {
    @Test
    public void student() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //虚拟机关闭之前自动执行 close() 方法(回调函数)
        ((ClassPathXmlApplicationContext) applicationContext).registerShutdownHook();
        //该方法判断是否存在某个对象
        Student student = (Student) applicationContext.getBean("student");
        Student student2 = (Student) applicationContext.getBean("student");
        System.out.println("这是单例模式吗？" + (student == student2));
        System.out.println("student = " + student);

        /*
        @Component 给对象添加实例化注解
        @Value() 给基本数据类型属性赋值
        @Autowired 给引用数据类型赋值（该引用数据类型也要加实例化注解）
         */
    }

}