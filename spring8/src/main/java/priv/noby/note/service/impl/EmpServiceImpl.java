package priv.noby.note.service.impl;

import priv.noby.note.dao.EmpDao;
import priv.noby.note.entity.Emp;
import priv.noby.note.service.EmpService;

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
