package priv.noby.mavenssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.noby.mavenssm.service.EmpService;
import priv.noby.note.dao.EmpDao;
import priv.noby.note.entity.Emp;

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
