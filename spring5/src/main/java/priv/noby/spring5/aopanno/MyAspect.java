package priv.noby.spring5.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类(对应jdk和cglib中的增强类)，该类中的方法织入切点后形成代理方法
 *
 * @author Noby
 * @since 2022/10/15
 */
//注入Spring容器
@Component("myAspect")
//标注当前MyAspect是一个切面类
@Aspect
public class MyAspect{
    /**
     * 定义切点表达式
     *
     * 用于其他通知复用该切点表达式
     */
    @Pointcut("execution(* priv.noby.spring5.aopanno.*.*(..))")
    public void pointcut(){}

    /**
     * 前置通知 <aop:before> 用于配置前置通知。指定增强的方法在切入点方法之前执行
     */
    //引用切点表达式的第一种方式
    @Before("pointcut()")
    public void before() {
        System.out.println("MyAspect.before 切面对象的前置通知");
    }

    /**
     * 后置通知 <aop:after-returning> 用于配置后置通知。指定增强的方法在切入点方法之后执行
     */
    //引用切点表达式的第二种方式
    @AfterReturning("priv.noby.spring5.aopanno.MyAspect.pointcut()")
    public void afterReturning() {
        System.out.println("MyAspect.afterReturning 切面对象的后置通知");
    }

    /**
     * 环绕通知 <aop:around> 用于配置环绕通知。指定增强的方法在切入点方法之前和之后都执行
     */
    //直接书写切点表达式
    @Around("execution(* priv.noby.spring5.aopanno.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //Proceeding JoinPoint:  正在执行的连接点(切点)
        System.out.println("MyAspect.around 切面对象的环绕前置通知");
        Object proceed = pjp.proceed();//切点方法
        System.out.println("MyAspect.around 切面对象的环绕后置通知");
        return proceed;
    }

    /**
     * 异常抛出通知 <aop:throwing> 用于配置异常抛出通知。指定增强的方法在出现异常时执行
     *
     * 当目标方法出现异常时后置通知和环绕通知中的后置通知将不会执行，只有最终通知不受异常的影响都会执行
     */
    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("MyAspect.afterThrowing 切面对象的异常抛出通知");
    }

    /**
     * 最终通知 <aop:after> 用于配置最终通知。无论增强方式执行是否有异常都会执行
     */
    @After("pointcut()")
    public void after() {
        System.out.println("MyAspect.after 切面对象的最终通知");
    }
}

