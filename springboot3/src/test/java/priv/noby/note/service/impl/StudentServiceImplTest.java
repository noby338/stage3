package priv.noby.note.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import priv.noby.note.service.StudentService;

/**
 * springboot测试类的使用
 *
 * @author Noby
 * @since 2022/10/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {
    @Autowired
    StudentService studentService;

    @Test
    public void tsetSelectById() {
        studentService.selectById(1);
    }
}
