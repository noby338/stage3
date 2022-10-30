package priv.noby.mavenssm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import priv.noby.mavenssm.service.DepService;

/**
 * @author Noby
 * @since 2022/10/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-datasource.xml","classpath:spring-mybatis.xml","classpath:spring-service.xml"})
public class DepServiceImplTest {
    @Autowired
    DepService depService;

    @Test
    public void findAll() {
        System.out.println("depService.findAll() = " + depService.findAll());
    }
}