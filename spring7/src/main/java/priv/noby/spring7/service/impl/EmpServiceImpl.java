package priv.noby.spring7.service.impl;

import priv.noby.spring7.dao.EmpDao;
import priv.noby.spring7.entity.Emp;
import priv.noby.spring7.service.EmpService;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    EmpDao empDao;

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }

    @Override
    public List<Emp> selectAll() {
        return empDao.selectAll();
    }
}
