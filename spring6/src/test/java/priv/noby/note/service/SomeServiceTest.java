package priv.noby.note.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SomeServiceTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //可以通过字节码对象实例化 SomeService
        SomeService someService = applicationContext.getBean(SomeService.class);
        someService.doSome();
        someService.doSome2();
        someService.some();
        someService.some2();

        System.out.println("======");
        try {
            someService.some3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}