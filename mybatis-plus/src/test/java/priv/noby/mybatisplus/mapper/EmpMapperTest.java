package priv.noby.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.noby.mybatisplus.entity.Emp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * mybatis-plus生成的sql
 *
 * @author Noby
 * @since 2023/7/11
 */
@SpringBootTest
class EmpMapperTest {
    @Autowired
    EmpMapper empMapper;

    @Test
    void selectByIdTest() {
        Emp emp = empMapper.selectById(3);
        System.out.println("emp = " + emp);
    }

    @Test
    void selectOneTest() {
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "noby");
        //结果超过一条数据会发生异常
        Emp emp = empMapper.selectOne(wrapper);
        System.out.println("emp = " + emp);
    }

    @Test
    void selectCountTest() {
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        //id大于19的对象
        wrapper.gt("id", 19);
        //结果超过一条数据会发生异常
        Integer count = empMapper.selectCount(wrapper);
        System.out.println("count = " + count);
    }

    @Test
    void selectListTest() {
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.like("name", "no");
        List<Emp> emps = empMapper.selectList(wrapper);
        System.out.println("emps = " + emps);
    }

    @Test
    void selectPageTest() {
        //第2页，每页3条数据
        Page<Emp> page = new Page<>(2,3);
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        //id大于19的对象
        wrapper.gt("id", "6");
        IPage<Emp> iPage = empMapper.selectPage(page, wrapper);
        System.out.println("总条数 iPage.getTotal() = " + iPage.getTotal());
        System.out.println("总页数 iPage.getPages() = " + iPage.getPages());
        System.out.println("当前页 iPage.getCurrent() = " + iPage.getCurrent());
        System.out.println("每页数量 iPage.getSize() = " + iPage.getSize());
        System.out.println("当前页内容 iPage.getRecords() = " + iPage.getRecords());
    }

    @Test
    void selectBatchIdsTest() {
        List<Emp> emps = empMapper.selectBatchIds(Arrays.asList(2, 3, 4));
        System.out.println("emps = " + emps);
    }


    @Test
    void insertTest() {
        Emp emp = new Emp();
        emp.setName("小明");
        //@TableId(type = IdType.AUTO)，通过在entity中id属性设置注解，时该主键增长的方式为自增(默认为NONE，随机填充)
        int insert = empMapper.insert(emp);
        //默认返回的时增加的条数
        System.out.println("insert = " + insert);
        //自增长的值会回填到对象中
        System.out.println("emp = " + emp);
    }

    /**
     * 测试自动注入did
     */
    @Test
    void insertTest2() {
        Emp emp = new Emp();
        emp.setName("noby");
        int insert = empMapper.insert(emp);
        System.out.println("insert = " + insert);
        System.out.println("emp = " + emp);
    }

    @Test
    void updateByIdTest() {
        Emp emp = new Emp();
        emp.setId(21);
        emp.setName("noby");
        int update = empMapper.updateById(emp);
        System.out.println("update = " + update);
        //自增长的值会回填到对象中
        System.out.println("emp = " + emp);
    }

    @Test
    void updateTest() {
        Emp emp = new Emp();
        emp.setName("kace");
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 21);
        //emp为更新的内容，wrapper为更新的条件
        int update = empMapper.update(emp, wrapper);
        System.out.println("update = " + update);
    }

    @Test
    void updateTest2() {
        UpdateWrapper<Emp> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", 21).set("name", "july").set("did", 3);
        //set为更新的内容，eq为更新的条件
        int update = empMapper.update(null, wrapper);
        System.out.println("update = " + update);
    }

    @Test
    void deleteByIdTest() {
        int delete = empMapper.deleteById(22);
        System.out.println("delete = " + delete);
    }

    @Test
    void deleteByMapTest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "july");
        map.put("did", 2);
        //删除的条件为map中的元素的and关系
        int delete = empMapper.deleteByMap(map);
        System.out.println("delete = " + delete);
    }

    @Test
    void deleteTest() {
        Emp emp = new Emp();
        emp.setName("july");
        emp.setDid(2);
        QueryWrapper<Emp> wrapper = new QueryWrapper<>(emp);
        int delete = empMapper.delete(wrapper);
        System.out.println("delete = " + delete);
    }

    @Test
    void deleteTest2() {
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "july")
                .eq("did", 2);
        int delete = empMapper.delete(wrapper);
        System.out.println("delete = " + delete);
    }

    @Test
    void deleteBatchIdsTest() {
        int delete = empMapper.deleteBatchIds(Arrays.asList(21, 22));
        System.out.println("delete = " + delete);
    }


    @Test
    void allEqTest() {
        Map<String,Object> maps = new HashMap<>();
        maps.put("id", null);
        maps.put("name", "noby");
        maps.put("did", 3);

        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        //SELECT id,name,did FROM emp WHERE (name = ? AND id IS NULL AND did = ?)
        wrapper.allEq(maps);
        //SELECT id,name,did FROM emp WHERE (name = ? AND did = ?)
//        wrapper.allEq(maps, false);
        //SELECT id,name,did FROM emp WHERE (name = ? AND did = ?)
//        wrapper.allEq((k, v) -> (k.equals("name") || k.equals("did")) , maps);

        List<Emp> emps = empMapper.selectList(wrapper);
        System.out.println("emps = " + emps);
    }

    /**
     * 条件构造器
     */
    @Test
    void wrapperTest() {
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        //region 条件构造器
//        wrapper.eq("name", "noby");
        /*
         * eq() 等于
         * ne() 不等于
         * gt() 大于
         * ge() 大于等于
         * lt() 小于
         * le() 小于等于
         * between() 两者之间
         * notBetween() 两者之外
         * in() 之间
         * notIn() 之外
         */
        /*
         * like() LIKE '%param%'
         * noteLike() NOT LIKE '%param%'
         * likeLeft() LIKE '%param'
         * likeRight() LIKE 'param%'
         */
        //endregion

        //region 排序
        //SELECT id,name,did FROM emp ORDER BY did DESC
//        wrapper.orderByDesc("did");
        /*
         * orderBy() ORDER BY did ASC
         * orderByAsc() ORDER BY did ASC
         * orderByDesc() ORDER BY did DESC
         */
        //endregion

        //region 逻辑
//        wrapper.eq("name", "noby").
//                or().eq("id", 4);
        //endregion

        //region 字段
        wrapper.eq("did", "2")
                .select("id","name");
        //endregion


        List<Emp> emps = this.empMapper.selectList(wrapper);
        System.out.println("emps = " + emps);

    }



}