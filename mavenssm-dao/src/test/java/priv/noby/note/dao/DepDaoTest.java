package priv.noby.note.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import priv.noby.note.entity.Dep;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Noby
 * @since 2022/10/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-datasource.xml","classpath:spring-mybatis.xml"})
public class DepDaoTest {
    @Resource
    DepDao depdao;

    @Test
    public void selectAll() {
        System.out.println("depdao = " + depdao);
        List<Dep> deps = depdao.selectAll();
        System.out.println("deps = " + deps);
    }

    @Test
    public void selectAll2() {
        System.out.println(11);
    }

}