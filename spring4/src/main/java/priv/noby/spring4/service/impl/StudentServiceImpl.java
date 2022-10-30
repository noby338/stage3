package priv.noby.spring4.service.impl;

import org.springframework.stereotype.Service;
import priv.noby.spring4.dao.StudentDao;
import priv.noby.spring4.entity.Student;
import priv.noby.spring4.service.StudentService;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    /*
    使用 @Autowired 注解导入 Mapper 对象报错的原因，是因为 @Autowired 默认情况下，需要注入一个非 NULL 的对象，
    而被 @Mapper 修饰的类为 MyBatis 的注解，IDEA 并不能很好的识别其为非 NULL 对象，因此就会报错。
    当然，它的解决方案也有很多，推荐使用 @Resource 替代 @Autowired 注解的方式来解决此问题。
     */
//    @Autowired
    @Resource
    StudentDao studentDao;

    @Override
    public Student selectById(int id) {
        return studentDao.selectById(id);
    }

    @Override
    public boolean insert(Student student) {
        return studentDao.insert(student);
    }

}
