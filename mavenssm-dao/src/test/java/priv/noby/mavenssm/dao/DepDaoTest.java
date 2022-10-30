package priv.noby.mavenssm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import priv.noby.note.entity.Dep;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author Noby
 * @since 2022/10/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-datasource.xml","classpath:spring-mybatis.xml"})
public class DepDaoTest {
    @Autowired
    DataSource dataSource;
    @Resource
    DepDao depdao;

    @Test
    public void datasource() {
        System.out.println("dataSource = " + dataSource);
    }

    @Test
    public void selectAll() {
        List<Dep> deps = depdao.selectAll();
        System.out.println("deps = " + deps);
    }


}