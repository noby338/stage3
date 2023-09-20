package priv.noby.mybatisplusgenerator.service.impl;

import priv.noby.mybatisplusgenerator.entity.Emp;
import priv.noby.mybatisplusgenerator.mapper.EmpMapper;
import priv.noby.mybatisplusgenerator.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
