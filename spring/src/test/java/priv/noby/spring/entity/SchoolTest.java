package priv.noby.spring.entity;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试子配置文件是否引入成功
 *
 * @author Noby
 * @since 2022/10/9
 */
public class SchoolTest extends TestCase {
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        School schoolOther = (School) ac.getBean("schoolOther");
        System.out.println("schoolOther = " + schoolOther);
    }
}