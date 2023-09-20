package priv.noby.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.noby.mybatisplus.entity.Emp;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 插入
     */
    @Test
    void testSave() {
        Emp emp = new Emp();
        emp.setName("noby");
        emp.setDid(3);
        boolean b = empService.save(emp);
        System.out.println("b = " + b);
        System.out.println("emp = " + emp);
    }

    /**
     * 插入多行
     */
    @Test
    void testSaveBatch() {
        Emp emp = new Emp();
        emp.setName("noby");
        emp.setDid(1);
        List<Emp> empList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            empList.add(emp);
        }
        boolean b = empService.saveBatch(empList);
        System.out.println("b = " + b);
    }

    /**
     * 根据id删除
     */
    @Test
    void testRemoveById() {
        boolean b = empService.removeById(27);
        System.out.println("b = " + b);

    }

    /**
     * 按条件批量删除
     */
    @Test
    void testRemove() {
        Emp emp = new Emp();
        emp.setName("noby");
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        UpdateWrapper<Emp> updateWrapper = new UpdateWrapper<>();
        wrapper.eq("name", "noby");
        boolean b = empService.remove(wrapper);

    }



    /**
     * 根据id更新
     */
    @Test
    void testUpdateById() {
        Emp emp = new Emp();
        emp.setId(25);
        emp.setName("noby");
        boolean b = empService.updateById(emp);
        System.out.println("b = " + b);
        System.out.println("emp = " + emp);

    }

    /**
     * 根据id查询
     */
    @Test
    void testGetById() {
        Emp emp = empService.getById(3);
        System.out.println("emp = " + emp);

    }

    /**
     * 根据条件查询一个，多于一个报错
     */
    @Test
    void testGetOne() {
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "noby");
        Emp emp = empService.getOne(wrapper);
        System.out.println("emp = " + emp);

    }

    /**
     * 根据条件查询多个
     */
    @Test
    void testList() {
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "noby");
        List<Emp> list = empService.list(wrapper);
        System.out.println("list = " + list);
    }


    /**
     * 根据条件分页查询多个
     */
    @Test
    void testPage() {
        Page<Emp> page = new Page<>(2,3);
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "noby");
        Page<Emp> iPage = empService.page(page, wrapper);
        System.out.println("总条数 iPage.getTotal() = " + iPage.getTotal());
        System.out.println("总页数 iPage.getPages() = " + iPage.getPages());
        System.out.println("当前页 iPage.getCurrent() = " + iPage.getCurrent());
        System.out.println("每页数量 iPage.getSize() = " + iPage.getSize());
        System.out.println("当前页内容 iPage.getRecords() = " + iPage.getRecords());

    }

}