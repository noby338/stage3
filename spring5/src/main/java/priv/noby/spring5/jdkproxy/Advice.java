package priv.noby.spring5.jdkproxy;

/**
 * 增强类(目标类中的目标方法将要织入增强代码，增强后生成代理对象)

 * @author Noby
 * @since 2022/10/15
 */
public class Advice {//中文为通知
    public void before() {
        System.out.println("Advice.before 增强对象的前置增强方法");
    }

    public void afterReturning() {
        System.out.println("Advice.afterReturning 增强对象的后置增强方法");
    }
}
