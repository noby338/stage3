package priv.noby.vuespringboot.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.noby.vuespringboot.entity.Emp;
import priv.noby.vuespringboot.service.EmpService;

@SpringBootTest
class EmpServiceImplTest {
    @Autowired
    EmpService empService;
    @Test
    void selectByEmp() {
        Emp emp = new Emp();
        emp.setEid(1);
        System.out.println("empService.selectByEmp(1,emp) = " + empService.selectByEmp(1, emp));
    }
}