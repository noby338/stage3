package priv.noby.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.noby.mybatisplus.entity.Emp;
import priv.noby.mybatisplus.mapper.EmpMapper;
import priv.noby.mybatisplus.service.IEmpService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author noby
 * @since 2023-07-14
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

}
