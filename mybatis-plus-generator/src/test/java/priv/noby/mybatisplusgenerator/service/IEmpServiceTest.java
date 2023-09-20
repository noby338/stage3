package priv.noby.mybatisplusgenerator.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.noby.mybatisplusgenerator.entity.Emp;

/**
 * @author Noby
 * @since 2023/7/14
 */
@SpringBootTest
class IEmpServiceTest {
    @Autowired
    IEmpService empService;
    @Test
    void testGetBaseMapper() {
        BaseMapper<Emp> baseMapper = empService.getBaseMapper();
        System.out.println("baseMapper.selectById(3) = " + baseMapper.selectById(3));
        System.out.println("baseMapper = " + baseMapper);

    }
    @Test
    void testSave() {
        Emp emp = new Emp();
        emp.setName("noby")
                .setDid(3);
        boolean b = empService.save(emp);
        System.out.println("b = " + b);
        System.out.println("emp = " + emp);
    }
    @Test
    void testGetById() {
        Emp emp = empService.getById(3);
        System.out.println("emp = " + emp);

    }
    @Test
    void testUpdateById() {
        Emp emp = new Emp();
        emp.setId(27);
        emp.setName("changed");
        boolean b = empService.updateById(emp);
        System.out.println("b = " + b);
        System.out.println("emp = " + emp);

    }

}