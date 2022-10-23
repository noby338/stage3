package priv.noby.note.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.noby.note.dao.EmpDao;
import priv.noby.note.entity.Emp;
import priv.noby.note.service.EmpService;

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
