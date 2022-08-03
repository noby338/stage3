package priv.noby.note.service.impl;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.noby.note.entity.Some;
import priv.noby.note.entity.Student;
import priv.noby.note.service.StudentService;

public class StudentServiceImplTest extends TestCase {

    /**
     * 使用默认装配方式创建对象
     */
    public void testShow() {
        //ApplicationContext 应用程序上下文，Spring 的核心类
        //读取配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //根据配置文件中的 bean 创建对象(底层调用的无参构造方法)
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.show();
    }

    /**
     * 使用动态工厂 bean 方式创建对象
     */
    public void testShow2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) ac.getBean("studentService2");
        studentService.show();
    }

    /**
     * 使用静态工厂 bean 方式创建对象(调用工厂的静态方法)
     */
    public void testShow3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) ac.getBean("studentService3");
        studentService.show();
    }

    /**
     * Bean 的作用域：单例、原型
     */
    public void testShow4() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //在创建 ApplicationContext 对象时，就已经将 student 实例化，通过 getBean() 获取该对象
        Student student = (Student) ac.getBean("student");
        student.setName("noby");
        Student student2 = (Student) ac.getBean("student");
        System.out.println("student2.getName() = " + student2.getName());
        System.out.println("这两个对象是同一个对象？" + (student == student2));
    }

    /**
     * Bean 的创建和销毁
     */
    public void testShow5() {
        /*
        在创建 ApplicationContext 对象时，就已经将 student 实例化(单例模式)，通过 getBean() 获取该对象，
        同时在 student 实例化的时候调用 init() 方法
        */
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //在单例模式中，且关闭容器（Spring）时执行 destroy() 方法
        ((ClassPathXmlApplicationContext) ac).close();
        /*
        原型的对象创建不是完全受Spring容器控制，spring对象创建以后，容器关闭，不能保证这个对象是否还在使用，
        所有容器关闭，也不能执行销毁。只有JVM的垃圾回收执行
         */

    }

    /**
     * Bean 设值注入 DI(dependency injection)（依赖注入）
     */
    public void testShow6() {
        //在实例化后调用 setter() 方法给对象赋值
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //设置注入
        Student student3 = (Student) ac.getBean("student3");
        System.out.println("student3 = " + student3);
        //通过对象名自动注入 school-bean 与 school 不同，注入失败
        Student student32 = (Student) ac.getBean("student32");
        System.out.println("student32 = " + student32);
        //通过类自动注入
        Student student33 = (Student) ac.getBean("student33");
        System.out.println("student33 = " + student33);
    }


    /**
     * Bean 构造注入 DI(dependency injection)（依赖注入）
     */
    public void testShow7() {
        //在实例化时调用有参构造方法给对象赋值
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student4 = (Student) ac.getBean("student4");
        System.out.println("student4.getAge() = " + student4.getName());
    }

    /**
     * 复杂属性的注入
     */
    public void testShow8() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Some some = (Some) ac.getBean("some");
        System.out.println("some = " + some);
    }

}