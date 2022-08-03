package priv.noby.note.service.impl;

import priv.noby.note.service.StudentService;

public class StudentServiceFactory {
    public StudentService getStudentService() {
        return new StudentServiceImpl();
    }

    public StudentService getStudentService2() {
        return new StudentServiceImpl2();
    }

    public static StudentService getStudentService3() {
        return new StudentServiceImpl2();
    }

}
