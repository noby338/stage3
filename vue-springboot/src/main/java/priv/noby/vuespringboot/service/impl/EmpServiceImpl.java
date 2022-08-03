package priv.noby.vuespringboot.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.noby.vuespringboot.dao.EmpDao;
import priv.noby.vuespringboot.entity.Emp;
import priv.noby.vuespringboot.service.EmpService;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpDao empDao;

    @Override
    public List<Emp> selectAll(int pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<Emp> emps = empDao.selectAll();
        return emps;
    }

    @Override
    public List<Emp> selectByEmp(int pageNum,Emp emp) {
        PageHelper.startPage(pageNum, 6);
        List<Emp> emps = empDao.selectByEmp(emp);
        return emps;
    }

    @Override
    public boolean deleteByEid(int eid) {
        return empDao.deleteByEid(eid);
    }

    @Override
    public boolean updateByEmp(Emp emp) {
        return empDao.updateByEmp(emp);
    }

    @Override
    public boolean insert(Emp emp) {
        return empDao.insert(emp);
    }
}
