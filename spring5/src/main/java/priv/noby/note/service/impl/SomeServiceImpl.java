package priv.noby.note.service.impl;

import priv.noby.note.service.SomeService;

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
    public void some() {
        System.out.println("SomeServiceImpl.some");
    }
}
