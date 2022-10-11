package priv.noby.note.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * SpringConfiguration类使用了 @Import(MapperScannerConfiguration.class) 注解引入该配置类
 */
//表示这是一个 Spring 的配置类
@Configuration
public class MybatisConfiguration {
    //该注解表示Spring会将当前方法的返回值以指定名称存储到Spring容器中
    //该注解通常用来配置非自定义类
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("priv.noby.note.dao");
        return mapperScannerConfigurer;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("priv.noby.note.entity");
        return sqlSessionFactoryBean;
    }

}
