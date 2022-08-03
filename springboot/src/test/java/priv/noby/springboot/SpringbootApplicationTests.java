package priv.noby.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import priv.noby.springboot.entity.Emp;
import priv.noby.springboot.entity.Emp2;

@SpringBootTest
// 该注解为 lombok 的注解，用于输出日志（自动创建日志对象）
@Slf4j
class SpringbootApplicationTests {
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    Emp emp;
    @Autowired
    Emp2 emp2;

    /**
     * 传统方式属性值注入
     */
    @Test
    void contextLoads() {
        System.out.println(applicationContext.containsBean("emp"));
        System.out.println(applicationContext.containsBean("dep"));
        System.out.println("emp = " + emp);
    }

    /**
     * @ConfigurationProperties 通过注解属性值注入
     */
    @Test
    void contextLoads2() {
        System.out.println(applicationContext.containsBean("emp2"));
        System.out.println(applicationContext.containsBean("dep2"));
        System.out.println("emp2 = " + emp2);
    }

    /**
     * springboot 中日志的使用(spring5 以后使用的都是 logback)
     * 日志门面（接口）        日志实现
     * commons-logging      log4j    (spring4使用的也是这一套日志技术）
     * slf4j                logback  (Spring5使用这种）
     *
     * 在配置文件中指定输出的级别和识别的包路径
     */
    @Test
    void logger() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

    /**
     * 通过 lombok 输出日志
     */
    @Test
    void logger2() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }

}
