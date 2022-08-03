package priv.noby.note.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//表示这是一个 Spring 的配置类
@Configuration
//配置包扫描 <context:component-scan base-package='priv.noby.note.service'"/>
@ComponentScan({"priv.noby.note.service","priv.noby.note.config"})
public class SpringConfig {

}
