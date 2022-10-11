package priv.noby.note.entity;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用student测试spring的无参构造方法实例化
 *
 * 单例模式和原型模式
 * 对象的init()初始化和destroy()销毁
 *
 * @author Noby
 * @since 2022/10/8
 */
public class StudentTest extends TestCase {
    /**
     * 单例模式和原型模式
     *
     * 单例模式实例化的时机为Spring容器被创建
     * 原型模式实例化的时机为调用getBean()方法
     */
    public void test() {
        //ApplicationContext 应用程序上下文，Spring 的核心类，该语句作用是读取配置文件
        //可在下一行加入断点查看bean的实例化时机，单例模式实例化的时机为Spring容器被创建，原型模式实例化的时机为调用getBean()方法
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println();
        //根据配置文件中的 bean 创建对象(底层调用Student的无参构造方法)
        Student studentSingleton = (Student) ac.getBean("studentSingleton");
        Student studentSingleton2 = (Student) ac.getBean("studentSingleton");
        //当只存该类的唯一bean是可使用字节码对象为参数实例化bean
//        Student studentClass = ac.getBean(Student.class);
        System.out.println("单例模式实例化的两个对象是否相同："+(studentSingleton == studentSingleton2));

        Student studentPrototype = (Student) ac.getBean("studentPrototype");
        Student studentPrototype2 = (Student) ac.getBean("studentPrototype");
        System.out.println("原型模式实例化的两个对象是否相同："+(studentPrototype == studentPrototype2));

        /*
        Student.Student 无参构造 studentSingleton
        Student.Student 无参构造 studentSingleton
        Student.init 在该test中可忽略
        单例模式实例化的两个对象是否相同：true
        Student.Student 无参构造 studentPrototype
        Student.Student 无参构造 studentPrototype
        原型模式实例化的两个对象是否相同：false
         */

    }

    /**
     * 对象的init()初始化和destroy()销毁
     *
     * 单例模式初始化的时机为执行实例化后(实例化由Spring容器加载时实例化且只有一次，因此初始化也只有一次)
     * 原型模式初始化的时机为执行实例化后(实例化调用getBean()方法，每实例化一次执行一次)
     */
    public void test2() {
        //ApplicationContext 应用程序上下文，Spring 的核心类，该语句作用是读取配置文件
        //可在下一行加入断点查看bean的实例化时机，单例模式实例化的时机为Spring容器被创建，原型模式实例化的时机为调用getBean()方法
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //根据配置文件中的 bean 创建对象(底层调用Student的无参构造方法)
        Student studentInitAndDestroySingleton = (Student) ac.getBean("studentInitAndDestroySingleton");
        Student studentInitAndDestroySingleton2 = (Student) ac.getBean("studentInitAndDestroySingleton");

        Student studentInitAndDestroyPrototype = (Student) ac.getBean("studentInitAndDestroyPrototype");
        Student studentInitAndDestroyPrototype2 = (Student) ac.getBean("studentInitAndDestroyPrototype");

        //关闭容器查看两者的销毁方法，单例的销毁时机在容器销毁时，原型的销毁时机在java的垃圾回收机制回收
        ((ClassPathXmlApplicationContext)ac).close();

        /*
        Student.Student 无参构造 studentSingleton
        Student.Student 无参构造 studentInitAndDestroySingleton
        Student.init studentInitAndDestroySingleton
        Student.Student 无参构造 studentInitAndDestroyPrototype
        Student.init studentInitAndDestroyPrototype
        Student.Student 无参构造 studentInitAndDestroyPrototype2
        Student.init studentInitAndDestroyPrototype2
        Student.destroy studentInitAndDestroySingleton
         */
    }
}
