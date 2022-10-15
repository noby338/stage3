package priv.noby.note.aopanno;

import org.springframework.stereotype.Component;

/**
 * 目标类(将被增强的类)
 *
 * @author Noby
 * @since 2022/10/15
 */
@Component("target")
public class Target implements TargetInterface {
    @Override
    public void method() {
        System.out.println("Target.method 目标对象的目标方法运行");
        //模拟异常通知
//        int i = 1/0;
    }
}
