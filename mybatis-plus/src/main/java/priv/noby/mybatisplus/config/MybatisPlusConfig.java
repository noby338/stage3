package priv.noby.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatisplus的配置
 *
 * @author Noby
 * @since 2023/7/12
 */
@Configuration
@MapperScan("priv.noby.mybatisplus.mapper")
public class MybatisPlusConfig {
    /**
     * 配置分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
