package priv.noby.springboot3.constant;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 该类是用于数据共享的类，用于将成员变量赋值给静态属性
 */
@Component
public class Constant implements InitializingBean {
    @Value("${constant.information}")
    private String information;

    public static String INFORMATION;

    /**
     * 该方法可以在实例化之后立即执行，用于将成员变量赋值给静态属性
     */
    @Override
    public void afterPropertiesSet() {
        INFORMATION = information;
    }
}
