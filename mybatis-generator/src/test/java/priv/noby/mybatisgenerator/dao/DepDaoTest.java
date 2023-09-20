package priv.noby.mybatisgenerator.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.noby.mybatisgenerator.entity.Dep;

/**
 * @author Noby
 * @since 2023/7/11
 */
@SpringBootTest
class DepDaoTest {
    @Autowired
    DepDao depDao;

    @Test
    void selectByPrimaryKey() {
//        System.out.println("depMapper = " + depDao);
        Dep dep = depDao.selectByPrimaryKey(1);
        System.out.println("dep = " + dep);
    }
}