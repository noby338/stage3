package priv.noby.note.entity;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 复杂数据设值的注入
 *
 * @author Noby
 * @since 2022/10/8
 */
public class SomeTest extends TestCase {
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println();
        Some some = (Some) ac.getBean("some");
        System.out.println(some);
    }

}