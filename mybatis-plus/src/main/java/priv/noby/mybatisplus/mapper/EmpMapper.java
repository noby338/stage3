package priv.noby.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import priv.noby.mybatisplus.entity.Emp;

/**
 * 员工
 *
 * @author Noby
 * @since 2023/7/11
 */
public interface EmpMapper extends BaseMapper<Emp> {
    Emp findById(long id);
}
