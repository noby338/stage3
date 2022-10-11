package priv.noby.note.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 配置类相关注解的使用
 */
//表示这是一个 Spring 的配置类
@Configuration
//配置包扫描 <context:component-scan base-package='priv.noby.note.service'"/>
@ComponentScan("priv.noby.note.service")
//加载其他配置文件 <context:property-placeholder location="classpath:db.properties"/>
@PropertySource("classpath:db.properties")
//加载其他配置类 <import resource="applicationContext-other.xml"/> (该参数为数组，多个时将多个参数用classes = {})
@Import(MybatisConfiguration.class)
public class SpringConfiguration {
    //${}是Spring四大核心中的spEL(Spring表达式)，通过spEL获取db.properties导入spring容器中的数据
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //该注解表示Spring会将当前方法的返回值以指定名称存储到Spring容器中
    //该注解通常用来配置非自定义类
    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        druidDataSource.setUrl("jdbc:mysql://localhost:3306/note");
//        druidDataSource.setUsername("root");
//        druidDataSource.setPassword("123");
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }


}
