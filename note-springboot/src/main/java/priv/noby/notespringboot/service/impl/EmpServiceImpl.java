package priv.noby.notespringboot.service.impl;

import priv.noby.notespringboot.dao.EmpDao;
import priv.noby.notespringboot.entity.Emp;
import priv.noby.notespringboot.service.EmpService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Emp)表服务实现类
 *
 * @author Noby
 * @since 2022-10-30 14:17:42
 */
@Service("empService")
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpDao empDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Emp queryById(Integer id) {
        return this.empDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param emp 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Emp> queryByPage(Emp emp, PageRequest pageRequest) {
        long total = this.empDao.count(emp);
        return new PageImpl<>(this.empDao.queryAllByLimit(emp, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param emp 实例对象
     * @return 实例对象
     */
    @Override
    public Emp insert(Emp emp) {
        this.empDao.insert(emp);
        return emp;
    }

    /**
     * 修改数据
     *
     * @param emp 实例对象
     * @return 实例对象
     */
    @Override
    public Emp update(Emp emp) {
        this.empDao.update(emp);
        return this.queryById(emp.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.empDao.deleteById(id) > 0;
    }
}
