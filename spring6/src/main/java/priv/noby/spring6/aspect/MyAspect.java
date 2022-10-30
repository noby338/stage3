package priv.noby.spring6.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//切面注解
@Aspect
@Component
public class MyAspect {
    //前置通知注解
    @Before("execution(* do*(..))")
    public void before() {
        System.out.println("前置通知");
    }

    //定义一个切入点表达式方法，以方便复用
    @Pointcut("execution(* do*(..))")
    public void pointCut() {

    }

    //后置通知注解，使用了切入点表达式方法
    @AfterReturning("pointCut()")
    //JoinPoint 表示切入点
    public void after(JoinPoint joinPoint) {
        System.out.println("后置通知,JoinPoint:" + joinPoint);
    }

    //后置通知获取目标函数的返回值
    @AfterReturning(value = "execution(* some(..))", returning = "obj")
    public void someAfter(Object obj) {
        System.out.println("后置通知获取目标函数的返回值：" + obj);
    }

    //环绕通知，可同时处理前置通知，后置通知（可修改返回值），异常通知
    @Around("execution(* some2(..))")
    public Object around(ProceedingJoinPoint pjp) {
        Object obj = null;
        String objString = null;
        try {
            System.out.println("前置通知");
            obj = pjp.proceed();
            objString = obj.toString().toUpperCase();
            System.out.println("后置通知，修改返回值：" + objString);
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("异常通知");
        } finally {
            System.out.println("最终通知");
        }
        return objString;
    }

    //异常通知，e表示指定捕获的异常对象（没有捕获到则不执行该切面）
    @AfterThrowing(value = "execution(* some3(..))", throwing = "e")
    public void afterThrowing(RuntimeException e) {
        System.out.println("程序异常,e:" + e);
    }

    //最终通知（在发生异常后仍会执行）
    @After("execution(* some3(..))")
    public void after() {
        System.out.println("最终通知");
    }
}

/*
切入点表达式：规定给满足条件的方法切入通知

execution([modifiers-pattern]访问权限类型
            ret-type-pattern返回值类型 *
            [declaring-type-pattern]全限定性类名
            name-pattern(param-pattern)方法名（参数名） *
            [throws-pattern] 抛出异常类型
)

通配符：
*   0至多个任意字符
..  用在方法参故中，表示任意多个参数;用在包名后，表示当前包及其子包路径
+   用在类名后，表示当前类及其子类;用在接口后，表示当的接口及其实现类
 */
