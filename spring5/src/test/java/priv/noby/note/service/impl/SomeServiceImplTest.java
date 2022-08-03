package priv.noby.note.service.impl;

import org.junit.Test;
import priv.noby.note.service.SomeService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理方法对某个类进行增强 JDK Proxy
 */
public class SomeServiceImplTest {

    @Test
    public void testDoSome() {
        //目标对象
        SomeService someService = new SomeServiceImpl();
        //使用JDK的Proxy动态代理增强目标对象功能,得到一个代理对象
        //参数1：ClassLoader loader,       类加载器
        //参数2：Class<?>[] interfaces,    要增强的目标类型的所有接口的Class数组，JDK动态代理只能增强有接口的类型
        //参数3：InvocationHandler接口      实现这个接口中的invoke()方法，这个方法中定义如何对目标对象进行增强（一般使用匿名内部类）
        SomeService proxySomeService = (SomeService) Proxy.newProxyInstance(
                someService.getClass().getClassLoader(),
                someService.getClass().getInterfaces(),
                new InvocationHandler() {
                    //参数1：Object proxy,     代理对象
                    //参数2：Method method,    目标方法：要增强的接口中的方法
                    //参数3：Object[] args     目标方法对应的参数
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //invoke方法增强的时候不能使用参数proxy,StackOverflowError
                        //System.out.println(proxy);
                        Object obj;
                        if (method.getName().startsWith("do")) {//只对 do 开头的方法进行增强
                            //交叉业务
                            System.out.println("前置增强");
                            //使用反射直接调用目标对象中的方法----主业务
                            obj = method.invoke(someService, args);
                            //交叉业务
                            System.out.println("后置增强");
                        } else {
                            obj = method.invoke(someService, args);
                        }
                        return obj;
                    }
                }
        );
        proxySomeService.doSome();
        proxySomeService.doSome2();
        proxySomeService.some();
    }
}