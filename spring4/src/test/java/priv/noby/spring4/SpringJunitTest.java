package priv.noby.spring4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import priv.noby.spring4.config.MybatisConfiguration;
import priv.noby.spring4.config.SpringConfiguration;
import priv.noby.spring4.entity.Student;
import priv.noby.spring4.service.StudentService;

/**
 * Spring整合Junit测试
 *
 * @author Noby
 * @since 2022/10/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件的注解
//@ContextConfiguration("classpath:applicationContext.xml")
//加载配置类的注解
@ContextConfiguration(classes = {SpringConfiguration.class, MybatisConfiguration.class})
public class SpringJunitTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void test() {
        Student student = studentService.selectById(1);
        System.out.println("student = " + student);

    }
}
