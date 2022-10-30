package priv.noby.spring.factory;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.noby.spring.entity.School;

/**
 * 使用student测试spring Bean的另外两种实例化方式
 *
 * @author Noby
 * @since 2022/10/8
 */
public class SchoolFactoryTest extends TestCase {
    /**
     * 静态工厂和动态工厂实例化方式
     */
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        School schoolStatic = (School) ac.getBean("schoolStatic");
        School schoolDynamic = (School) ac.getBean("schoolDynamic");
        System.out.println("studentStatic = " + schoolStatic);
        System.out.println("studentDynamic = " + schoolDynamic);

        /*
        Student.Student 无参构造 studentSingleton
        Student.Student 无参构造 studentInitAndDestroySingleton
        Student.init 在该test中可忽略
        StaticFactory.getSchool
        School.School 无参构造
        DynamicFactory.DynamicFactory 无参构造
        DynamicFactory.getSchool
        School.School 无参构造
        studentStatic = School(scId=0, scName=null)
        studentDynamic = School(scId=0, scName=null)
         */

    }
}
