package priv.noby.springboot.constant;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 该类是用于数据共享的类
 * 实现 InitializingBean 接口是为了重写 afterPropertiesSet 方法
 */
@Component
public class Constant implements InitializingBean {
    @Value("${constant.info}")
    private String info;
    public static String INFO;

    /**
     * 该方法可以在实例化之后立即执行，用于将成员变量赋值给静态属性
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        INFO = info;
    }
}
