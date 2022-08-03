package priv.noby.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.noby.springboot.constant.Constant;
import priv.noby.springboot.dao.EmpDao;
import priv.noby.springboot.entity.Emp;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
// 该注解为 lombok 的注解，用于输出日志（自动创建日志对象）
@Slf4j
class SpringbootApplicationTests {
//    @Autowired
//    ApplicationContext applicationContext;
    @Autowired
    DataSource dataSource;
    @Autowired
    EmpDao empDao;

    /**
     * 测试 springboot 整合 mybatis
     */
    @Test
    void contextLoads() {
        List<Emp> emps = empDao.selectAll();
        System.out.println("emps = " + emps);
    }

    /**
     * 查看数据源
     * 默认为 springboot 自带的 HikariDataSource
     * 可配置第三方数据源 druid
     */
    @Test
    void contextLoads2() {
        System.out.println("dataSource = " + dataSource);
    }

    /**
     * 测试数据共享
     */
    @Test
    void contextLoads3() {
        System.out.println("Constant.INFO = " + Constant.INFO);
    }

}
