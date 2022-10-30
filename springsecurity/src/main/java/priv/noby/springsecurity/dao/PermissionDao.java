package priv.noby.springsecurity.dao;

import priv.noby.springsecurity.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Permission)表数据库访问层
 *
 * @author Noby
 * @since 2022-10-30 14:48:27
 */
public interface PermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Permission queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param permission 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Permission> queryAllByLimit(@Param("permission") Permission permission, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param permission 查询条件
     * @return 总行数
     */
    long count(Permission permission);

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 影响行数
     */
    int insert(Permission permission);

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 影响行数
     */
    int update(Permission permission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

