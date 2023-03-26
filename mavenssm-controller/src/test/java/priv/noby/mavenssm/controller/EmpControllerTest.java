package priv.noby.mavenssm.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import priv.noby.mavenssm.service.EmpService;

/**
 * @author Noby
 * @since 2022/10/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-datasource.xml","classpath:spring-mybatis.xml","classpath:spring-service.xml"})
public class EmpControllerTest {
    @Autowired
    EmpService empService;
    @Test
    public void init() {
        System.out.println("empService.findAll() = " + empService.findAll());
    }
}