package priv.noby.springsecurity.service.impl;

import priv.noby.springsecurity.entity.Dep;
import priv.noby.springsecurity.dao.DepDao;
import priv.noby.springsecurity.service.DepService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Dep)表服务实现类
 *
 * @author Noby
 * @since 2022-10-30 14:17:42
 */
@Service("depService")
public class DepServiceImpl implements DepService {
    @Resource
    private DepDao depDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Dep queryById(Integer id) {
        return this.depDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dep 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Dep> queryByPage(Dep dep, PageRequest pageRequest) {
        long total = this.depDao.count(dep);
        return new PageImpl<>(this.depDao.queryAllByLimit(dep, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dep 实例对象
     * @return 实例对象
     */
    @Override
    public Dep insert(Dep dep) {
        this.depDao.insert(dep);
        return dep;
    }

    /**
     * 修改数据
     *
     * @param dep 实例对象
     * @return 实例对象
     */
    @Override
    public Dep update(Dep dep) {
        this.depDao.update(dep);
        return this.queryById(dep.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.depDao.deleteById(id) > 0;
    }
}
