package priv.noby.mybatisplus.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.noby.mybatisplus.entity.Emp;

/**
 * 自定义的 mybatis sql
 * @author Noby
 * @since 2023/7/11
 */
@SpringBootTest
class EmpMapperTest2 {
    @Autowired
    EmpMapper empMapper;

    @Test
    void findByIdTest() {
        Emp emp = empMapper.findById(3);
        System.out.println("emp = " + emp);
    }


}