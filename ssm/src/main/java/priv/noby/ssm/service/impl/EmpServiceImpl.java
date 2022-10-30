package priv.noby.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.noby.ssm.dao.EmpDao;
import priv.noby.ssm.entity.Emp;
import priv.noby.ssm.service.EmpService;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpDao empDao;
    @Override
    public List<Emp> findAll() {
        return empDao.selectAll();
    }
}
