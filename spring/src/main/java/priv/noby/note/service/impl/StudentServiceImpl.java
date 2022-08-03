package priv.noby.note.service.impl;

import priv.noby.note.service.StudentService;

public class StudentServiceImpl implements StudentService {
    @Override
    public void show() {
        System.out.println("使用 spring 创建 StudentServiceImpl 对象并调用了 show() 方法");
    }
}
