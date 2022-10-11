package priv.noby.note;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import priv.noby.note.entity.Emp;
import priv.noby.note.service.DepService;
import priv.noby.note.service.EmpService;

import java.util.List;

/**
 * Spring整合Junit测试
 *
 * @author Noby
 * @since 2022/10/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件的注解
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJunitTest {
    @Autowired
    private EmpService empService;

    @Autowired
    private DepService depService;

    @Test
    public void test() {
        List<Emp> emps = empService.selectAll();
        System.out.println("emps = " + emps);
    }
}
