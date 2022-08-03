package priv.noby.note.service.impl;

import org.springframework.stereotype.Component;
import priv.noby.note.service.SomeService;

@Component
public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome() {
        System.out.println("SomeServiceImpl.doSome");
    }

    @Override
    public void doSome2() {
        System.out.println("SomeServiceImpl.doSome2");
    }

    @Override
    public String some() {
        System.out.println("SomeServiceImpl.some");
        return "nothing";
    }

    @Override
    public String some2() {
//        int i = 2/0;
        System.out.println("SomeServiceImpl.some2");
        return "nothing2";
    }

    @Override
    public void some3() {
        if (true) {
            throw new RuntimeException();
        }
        System.out.println("SomeServiceImpl.some3");
    }
}
